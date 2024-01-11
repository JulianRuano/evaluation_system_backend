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
		
	}

}
