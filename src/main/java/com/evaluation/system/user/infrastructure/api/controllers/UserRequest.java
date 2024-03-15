package com.evaluation.system.user.infrastructure.api.controllers;

import java.util.Set;

import com.evaluation.system.user.domain.models.role.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    String username;
    String password;
    String name;
    String email;
    @Builder.Default
    boolean enabled = true;
    @Builder.Default
    String profile = "default.png"; 
    Set<UserRole> roles;
}
