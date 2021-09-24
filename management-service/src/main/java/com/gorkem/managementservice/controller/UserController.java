package com.gorkem.managementservice.controller;

import com.gorkem.managementservice.model.User;
import com.gorkem.managementservice.model.dto.UserDto;
import com.gorkem.managementservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping(path = "/v1/users")
public class UserController {

    private final UserService userService;
    private final RestTemplate restTemplate = new RestTemplate();

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add-user-w/{queueType}")
    public void addToRabbitMqQueue(@PathVariable("queueType") String queueType, @RequestBody UserDto userDto) {
        try {
            long start = System.currentTimeMillis();
            String thePortNumber = this.userService.findThePortNumber(queueType);

            User user = this.userService.convertForAddToRabbitMqQueue(userDto);

            var result = restTemplate.postForObject(
                    "http://localhost:" + thePortNumber + "/v1/" + queueType + "/add-to-line",
                    user,
                    User.class
            );
            long stop = System.currentTimeMillis();
            log.info("TOTAL TIME THE DATA WAS WRITTEN : {} MILLISECONDS", stop-start);
            if (thePortNumber.equals("")) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
