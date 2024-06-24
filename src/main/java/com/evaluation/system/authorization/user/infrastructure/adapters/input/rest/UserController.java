package com.evaluation.system.authorization.user.infrastructure.adapters.input.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.system.authorization.user.application.ports.input.IUserCreationManagerPort;
import com.evaluation.system.authorization.user.application.ports.input.IUserSearchManagerPort;
import com.evaluation.system.authorization.user.domain.models.User;
import com.evaluation.system.authorization.user.infrastructure.adapters.input.rest.data.request.user.UserCreateRequest;
import com.evaluation.system.authorization.user.infrastructure.adapters.input.rest.data.response.user.UserCreateResponse;
import com.evaluation.system.authorization.user.infrastructure.adapters.input.rest.data.response.user.UserGetResponse;
import com.evaluation.system.authorization.user.infrastructure.adapters.input.rest.mapper.IUserCreateMapper;
import com.evaluation.system.authorization.user.infrastructure.adapters.input.rest.mapper.IUserSearchMapper;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserCreationManagerPort userCreationManagerPort;
    private final IUserSearchManagerPort userSearchManagerPort;
    private final IUserCreateMapper userCreateMapper;
    private final IUserSearchMapper userSearchMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserController(IUserCreationManagerPort userCreationManagerPort, IUserSearchManagerPort userSearchManagerPort, IUserCreateMapper userCreateMapper, IUserSearchMapper userSearchMapper) {
        this.userCreationManagerPort = userCreationManagerPort;
        this.userSearchManagerPort = userSearchManagerPort;
        this.userCreateMapper = userCreateMapper;
        this.userSearchMapper = userSearchMapper;
    }

    @PostMapping("/")
    public ResponseEntity<UserCreateResponse>  saveUser(@RequestBody UserCreateRequest userCreateRequest) {
        User user = userCreateMapper.toUser(userCreateRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userCreationManagerPort.createUser(user);
        return ResponseEntity.ok(userCreateMapper.toUserCreateResponse(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserGetResponse> getUser(@PathVariable("id") Long id) {
        User user = userSearchManagerPort.getUserById(id);
        return ResponseEntity.ok(userSearchMapper.toUserGetResponse(user));
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        //TODO: implement delete user
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
    
}
