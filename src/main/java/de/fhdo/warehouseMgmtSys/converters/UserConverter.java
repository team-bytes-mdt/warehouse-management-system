package de.fhdo.warehouseMgmtSys.converters;

import de.fhdo.warehouseMgmtSys.domain.User;
import de.fhdo.warehouseMgmtSys.dto.UserDto;

public class UserConverter {
    //Convert from Entity to DTOs
    public static UserDto toDto(User userEntity) {
        return new UserDto(
                userEntity.getUserId(),
                userEntity.getName(),
                userEntity.getAddress(),
                userEntity.getRole(),
                userEntity.getPhoneNo()
        );
    }

    //Convert from Dto to Entity
    public static User toEntity(UserDto userDto) {
        User userEntity =  new User();
        userEntity.setName(userDto.getName());
        userEntity.setAddress(userDto.getAddress());
        userEntity.setRole(userDto.getRole());
        userEntity.setPhoneNo(userDto.getPhone());

        return userEntity;
    }
}
