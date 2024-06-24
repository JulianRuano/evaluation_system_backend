package com.evaluation.system.authorization.user.infrastructure.adapters.input.rest.data.response.user;

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
public class UserGetResponse {
    private Long id;
    private String username; 
    private String name;
    private String email;
    private String profile;

    private Role role;
}
