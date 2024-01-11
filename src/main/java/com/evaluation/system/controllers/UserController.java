package com.evaluation.system.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.system.models.Role;
import com.evaluation.system.models.User;
import com.evaluation.system.models.UserRole;
import com.evaluation.system.models.jwt.AuthResponse;
import com.evaluation.system.services.IUserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/")
    public ResponseEntity<AuthResponse>  saveUser(@RequestBody User user) throws Exception {
        Set<UserRole> roles = new HashSet<>();

        Role rol = new Role();
        rol.setRolId(45L);
        rol.setRolName("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(rol);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        roles.add(userRole);  
        return ResponseEntity.ok(userService.saveUser(user, roles));
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return userService.getUser(username);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }
}
