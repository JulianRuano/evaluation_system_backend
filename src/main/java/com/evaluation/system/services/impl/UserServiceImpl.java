package com.evaluation.system.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.system.repository.IUserRepository;
import com.evaluation.system.services.IUserService;
import com.evaluation.system.config.JwtUtils;
import com.evaluation.system.models.User;
import com.evaluation.system.models.UserRole;
import com.evaluation.system.models.jwt.AuthResponse;
import com.evaluation.system.models.jwt.LoginRequest;
import com.evaluation.system.repository.IRoleRepository;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IRoleRepository roleRepository;

	@Autowired
	private  JwtUtils jwtUtils;

	@Override
	public AuthResponse saveUser(User user, Set<UserRole> userRoles) throws Exception {

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
		return AuthResponse.builder()
				.token(jwtUtils.getToken(userLocal))
				.build();

	}

	@Override
	public User getUser(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);	
	}

	@Override
	public AuthResponse login(LoginRequest loginRequest) {
		User user = userRepository.findByUsername(loginRequest.getUsername());
		return AuthResponse.builder()
				.token(jwtUtils.getToken(user))
				.build();
	}
	
	
}
