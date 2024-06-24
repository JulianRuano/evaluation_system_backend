package com.evaluation.system.authorization.user.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    
    private Long id;
	private String username;
	private String password;
	private String name;
	private String email;
    private boolean enabled;
    private String profile;

    private Role role;
}
