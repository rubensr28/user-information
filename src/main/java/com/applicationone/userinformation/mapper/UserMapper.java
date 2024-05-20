package com.applicationone.userinformation.mapper;

import com.applicationone.userinformation.dto.UserDto;
import com.applicationone.userinformation.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto mapUsertoUserDto(User user);
    User mapUserDtotoUser(UserDto userDto);
}
