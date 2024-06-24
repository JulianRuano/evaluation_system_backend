package com.evaluation.system.authorization.user.infrastructure.adapters.input.rest.data.request.user;

import com.evaluation.system.authorization.user.domain.models.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {
    private String username;
    private String password;   
    private String name;
    private String email;
    private boolean enabled;
    private String profile;

    private Role role;
}
