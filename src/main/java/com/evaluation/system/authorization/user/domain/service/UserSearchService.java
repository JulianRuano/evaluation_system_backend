package com.evaluation.system.authorization.user.domain.service;

import org.springframework.stereotype.Service;

import com.evaluation.system.authorization.user.application.ports.input.IUserSearchManagerPort;
import com.evaluation.system.authorization.user.application.ports.output.IUserSearchOutputPort;
import com.evaluation.system.authorization.user.domain.models.User;

@Service
public class UserSearchService implements IUserSearchManagerPort{

    private final IUserSearchOutputPort userSearchPort;

    public UserSearchService(IUserSearchOutputPort userSearchPort) {
        this.userSearchPort = userSearchPort;
    }

    @Override
    public User getUserById(Long id) {
        return userSearchPort.getById(id);

    }
    
}
