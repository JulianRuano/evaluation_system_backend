package com.evaluation.system.services.user;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.system.repository.IUserRepository;
import com.evaluation.system.services.auth.JwtService;
import com.evaluation.system.controllers.auth.AuthResponse;
import com.evaluation.system.models.User;
import com.evaluation.system.models.UserRole;
import com.evaluation.system.repository.IRoleRepository;


@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IRoleRepository roleRepository;

	@Autowired
	private  JwtService jwtService;


	@Override
	public AuthResponse saveUser(User user, Set<UserRole> userRoles) throws Exception {

		Optional<User> userLocal = userRepository.findByUsername(user.getUsername());	
		if(userLocal != null) {
			System.out.println("El usuario ya existe");
			throw new Exception("El usuario ya está presente");
		}
		else {
			for(UserRole userRole:userRoles) {
				if (userRole.getRole() != null) { 
					roleRepository.save(userRole.getRole());
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
	public void deleteUser(Long id) {
		userRepository.deleteById(id);	
	}


	
	
}
