package com.evaluation.system.authorization.auth.infrastructure.api.controller.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.system.authorization.auth.application.service.AuthService;
import com.evaluation.system.authorization.user.infrastructure.adapters.output.jpaAdapter.Entity.user.UserEntity;
import com.evaluation.system.authorization.auth.infrastructure.exceptions.UserFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {
    
    private final AuthService authService;
    
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) throws UserFoundException
    {
        try {
            return ResponseEntity.ok(authService.register(request));
        } catch (UserFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AuthResponse("Error: Usuario ya existe"));
        }  
    }

    //obtener usuaruio del token por header
    @GetMapping("/getCurrentUser")
    public UserEntity getCurrentUser(@RequestHeader("Authorization") String authorizationHeader)
    {
       return authService.getCurrentUser(authorizationHeader);
    }

    //Ruta de comprobación de estado
    @GetMapping("/status")
    public ResponseEntity<String> status()
    {
        return ResponseEntity.ok("Servicio de autenticación en línea");
    }

}
    
