package com.gorkem.managementservice.controller;

import com.gorkem.managementservice.model.User;
import com.gorkem.managementservice.model.dto.UserDto;
import com.gorkem.managementservice.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/v1/users")
public class UserController {

    private final UserService userService;
    private final RestTemplate restTemplate = new RestTemplate();

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add-user-w-rabbitmq")
    public void addToRabbitMqQueue(@RequestBody UserDto userDto) {
        try {
            User user = this.userService.convertForAddToRabbitMqQueue(userDto);

            var result = restTemplate.postForObject(
                    "http://localhost:8086/v1/rabbitmq/add-to-queue",
                    user,
                    User.class
            );
            if (result == null) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
