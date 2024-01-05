package com.evaluation.system;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.evaluation.system.models.Role;
import com.evaluation.system.models.User;
import com.evaluation.system.models.UserRole;
import com.evaluation.system.services.IUserService;

@SpringBootTest
class EvaluationSystemBackendApplicationTests {

	@Autowired
	private IUserService userService;
	
	@Test
	void saveUserTest() throws Exception {
		User user = new User();
		
		user.setName("juan");
		user.setUsername("juan1");
		user.setPassword("12345");
		user.setCellPhone("32156");
		user.setEmail("juan@email.com");
		user.setProfile("image.png");
		
		Role role = new Role();
		role.setRolId(2L);
		role.setRolName("USER");
		
		Set<UserRole> userRoles = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		userRoles.add(userRole);
		
		User user1 = userService.saveUser(user,userRoles);
		
		assertTrue(user1.getName().equalsIgnoreCase(user.getName()));
	}

}
