package com.evaluation.system.user.application.services;

import java.util.Set;

import com.evaluation.system.auth.application.controller.auth.AuthResponse;
import com.evaluation.system.user.domain.models.role.UserRole;
import com.evaluation.system.user.domain.models.user.User;

public interface IUserService {
	public AuthResponse saveUser(User user,Set<UserRole> userRole) throws Exception;

	public User getUser(String username);

	public void deleteUser(Long id);
}
