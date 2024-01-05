package com.evaluation.system.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.system.repository.IUserRepository;
import com.evaluation.system.services.IUserService;
import com.evaluation.system.models.User;
import com.evaluation.system.models.UserRole;
import com.evaluation.system.repository.IRoleRepository;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IRoleRepository roleRepository;

	@Override
	public User saveUser(User user, Set<UserRole> userRoles) throws Exception {

		User userLocal = userRepository.findByUsername(user.getUsername());
		
		if(userLocal != null) {
			System.out.println("El usuario yua existe");
			throw new Exception("El usuario ya esta presente");
		}
		else {
			for(UserRole userRole:userRoles) {
				roleRepository.save(userRole.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			userLocal = userRepository.save(user);
		}
		return userLocal;

	}
	
	
}
