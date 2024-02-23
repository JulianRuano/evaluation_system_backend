package com.evaluation.system.auth.application.controller.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.system.auth.application.service.AuthService;
import com.evaluation.system.user.domain.models.user.User;
import com.evaluation.system.user.infrastructure.exceptions.UserFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {
    
    private final AuthService authService;
    
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) throws UserFoundException
    {
        try {
            return ResponseEntity.ok(authService.register(request));
        } catch (UserFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AuthResponse("Error: Usuario ya existe"));
        }  
    }

    //obtener usuaruio del token por header
    @GetMapping(value = "getCurrentUser")
    public User getCurrentUser(@RequestHeader("Authorization") String authorizationHeader)
    {
       return authService.getCurrentUser(authorizationHeader);
    }

}
    
