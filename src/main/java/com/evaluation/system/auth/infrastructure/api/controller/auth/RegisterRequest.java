package com.evaluation.system.auth.infrastructure.api.controller.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    String username;
    String password;
    String name;
    String email;
    String cellPhone;
    @Builder.Default
    boolean enabled = true;
    @Builder.Default
    String profile = "default.png"; 
}
