package com.evaluation.system.authorization.user.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.evaluation.system.authorization.user.domain.models.User;
import com.evaluation.system.authorization.user.infrastructure.adapters.input.rest.data.request.user.UserCreateRequest;
import com.evaluation.system.authorization.user.infrastructure.adapters.input.rest.data.response.user.UserCreateResponse;

@Mapper
public interface IUserCreateMapper {

    @Mapping(target = "id", ignore = true)
    User toUser(UserCreateRequest userCreateRequest);

    UserCreateRequest toUserCreateRequest(User user);   
    
    UserCreateResponse toUserCreateResponse(User user);

    @Mapping(target = "password", ignore = true)
    User toUser(UserCreateResponse userCreateResponse);  
}
