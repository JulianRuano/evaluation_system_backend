package com.evaluation.system.services.auth;

import org.springframework.stereotype.Service;
import org.springframework.boot.actuate.web.exchanges.HttpExchange.Principal;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.evaluation.system.controllers.auth.AuthResponse;
import com.evaluation.system.controllers.auth.LoginRequest;
import com.evaluation.system.controllers.auth.RegisterRequest;
import com.evaluation.system.models.User;
import com.evaluation.system.repository.IUserRepository;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final IUserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

     public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user=userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();

    }

    public AuthResponse register(RegisterRequest request) {

        //verificar si el usuario existe y request no es nulo
        @NotNull User userExists = userRepository.findByUsername(request.getUsername()).orElse(null);
        if (userExists != null) {
            AuthResponse.builder()
            .token("Error: Usuario ya existe")
            .build();
        }     
        User user = User.builder()
        .username(request.getUsername())
        .password(passwordEncoder.encode( request.getPassword()))
        .name(request.getName())
        .email(request.getEmail())
        .cellPhone(request.getCellPhone())
        .enabled(request.isEnabled())
        .profile(request.getProfile())
        .build();

        userRepository.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
        
    }

    //obtener usuaruio del token
    public User getUser(String authorizationHeader) {
        String token = authorizationHeader.substring(7);  
        String username = jwtService.getUsernameFromToken(token);
        
        return userRepository.findByUsername(username).orElse(null);      
    }
 


}