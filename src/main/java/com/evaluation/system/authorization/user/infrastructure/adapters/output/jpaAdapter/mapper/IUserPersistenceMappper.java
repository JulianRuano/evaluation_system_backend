package com.evaluation.system.authorization.user.infrastructure.adapters.output.jpaAdapter.mapper;

import com.evaluation.system.authorization.user.domain.models.User;
import com.evaluation.system.authorization.user.infrastructure.adapters.output.jpaAdapter.Entity.user.UserEntity;

public interface IUserPersistenceMappper {
    UserEntity toUserEntity(User user);
    User toUser(UserEntity userEntity);
}