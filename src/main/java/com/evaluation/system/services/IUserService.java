package com.evaluation.system.services;

import java.util.Set;

import com.evaluation.system.models.User;
import com.evaluation.system.models.UserRole;

public interface IUserService {
	public User saveUser(User user,Set<UserRole> userRole) throws Exception;

	public User getUser(String username);

	public void deleteUser(Long id);
}
