package com.evaluation.system.authorization.user.application.ports.output;

import com.evaluation.system.authorization.user.domain.models.User;

public interface IUserSearchOutputPort {
    User getById(Long id); 
}
