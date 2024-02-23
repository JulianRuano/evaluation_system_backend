package com.evaluation.system.user.application.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.system.user.domain.models.role.Role;
import com.evaluation.system.user.domain.models.role.UserRole;
import com.evaluation.system.user.domain.models.user.User;
import com.evaluation.system.user.domain.repository.IRoleRepository;
import com.evaluation.system.user.domain.repository.IUserRepository;

import lombok.NonNull;

import com.evaluation.system.auth.application.controller.auth.AuthResponse;
import com.evaluation.system.auth.application.service.JwtService;


@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IRoleRepository roleRepository;

	@Autowired
	private  JwtService jwtService;


	@Override
	public AuthResponse saveUser(User user,Set<UserRole> userRoles) throws Exception {

		Optional<User> userLocal = userRepository.findByUsername(user.getUsername());	
		if(userLocal != null) {
			System.out.println("El usuario ya existe");
			throw new Exception("El usuario ya está presente");
		}
		else {
			for(UserRole userRole:userRoles) {
				Role role = userRole.getRole();
				if (role != null) { 
					roleRepository.save(role);
				}				
			}
			user.getUserRoles().addAll(userRoles);
			userRepository.save(user);
		}
		return AuthResponse.builder()
				.token(jwtService.getToken(user))
				.build();

	}

	@Override
	public User getUser(String username) {
		Optional<User> user = userRepository.findByUsername(username);
		return user.orElse(null);
	}

	@Override
	public void deleteUser(@NonNull Long id) {
		userRepository.deleteById(id);	
	}


	
	
}
