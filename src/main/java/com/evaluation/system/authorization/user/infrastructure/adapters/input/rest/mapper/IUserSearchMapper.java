package com.evaluation.system.authorization.user.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.evaluation.system.authorization.user.domain.models.User;
import com.evaluation.system.authorization.user.infrastructure.adapters.input.rest.data.response.user.UserGetResponse;

@Mapper
public interface IUserSearchMapper {

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "enabled", ignore = true)
    User toUser(UserGetResponse userGetResponse);

    UserGetResponse toUserGetResponse(User user);
}
