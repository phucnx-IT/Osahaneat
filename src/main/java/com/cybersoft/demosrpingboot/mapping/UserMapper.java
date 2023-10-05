package com.cybersoft.demosrpingboot.mapping;

import com.cybersoft.demosrpingboot.dto.UserDto;
import com.cybersoft.demosrpingboot.entity.Users;
import com.cybersoft.demosrpingboot.payload.RegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto userToUserDTO(Users users);
    Users userDTOToUser(UserDto userDto);
    Users payloadRequestToUsers(RegisterRequest registerRequest);
}
