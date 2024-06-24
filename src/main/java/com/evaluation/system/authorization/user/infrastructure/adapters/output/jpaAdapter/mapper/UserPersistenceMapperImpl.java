package com.evaluation.system.authorization.user.infrastructure.adapters.output.jpaAdapter.mapper;

import org.springframework.stereotype.Component;

import com.evaluation.system.authorization.user.domain.models.User;
import com.evaluation.system.authorization.user.infrastructure.adapters.output.jpaAdapter.Entity.user.UserEntity;

@Component
public class UserPersistenceMapperImpl implements IUserPersistenceMappper{

    @Override
    public UserEntity toUserEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .name(user.getName())
                .email(user.getEmail())
                .profile(user.getProfile())         
                .build();
    }

    @Override
    public User toUser(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .profile(userEntity.getProfile())
                .build();
    }
    

    
}
