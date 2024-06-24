package com.evaluation.system.authorization.user.application.ports.input;
import com.evaluation.system.authorization.user.domain.models.User;

public interface IUserCreationManagerPort {
    User createUser(User user);    
}
