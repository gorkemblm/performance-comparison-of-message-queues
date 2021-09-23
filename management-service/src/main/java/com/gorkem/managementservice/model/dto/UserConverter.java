package com.gorkem.managementservice.model.dto;

import com.gorkem.managementservice.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public static User convertToEntity(UserDto userDto) {
        User user = new User();

        user.setActive(true);

        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setTag(userDto.getTag());

        return user;
    }

    public static UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setTag(user.getTag());

        return userDto;
    }
}
