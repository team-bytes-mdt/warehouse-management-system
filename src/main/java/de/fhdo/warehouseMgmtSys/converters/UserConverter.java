package de.fhdo.warehouseMgmtSys.converters;

import de.fhdo.warehouseMgmtSys.domain.User;
import de.fhdo.warehouseMgmtSys.dto.UserDto;

public class UserConverter {
    //Convert from Entity to DTOs
    public static UserDto toDto(User userEntity) {
        return new UserDto(
                userEntity.getName(),
                userEntity.getAddress(),
                userEntity.getRole(),
                userEntity.getPhoneNo()
        );
    }

    //Convert from Dto to Entity
    public static User toEntity(UserDto userDto) {
        User UserEntity =  new User();
        userDto.setName(userDto.getName());
        userDto.setAddress(userDto.getAddress());
        userDto.setRole(userDto.getRole());
        userDto.setPhone(userDto.getPhone());

        return UserEntity;
    }
}
