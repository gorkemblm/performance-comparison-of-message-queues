package com.gorkem.managementservice.service;

import com.gorkem.managementservice.model.User;
import com.gorkem.managementservice.model.dto.UserConverter;
import com.gorkem.managementservice.model.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User convertForAddToRabbitMqQueue(UserDto userDto) {
        return UserConverter.convertToEntity(userDto);
    }
}
