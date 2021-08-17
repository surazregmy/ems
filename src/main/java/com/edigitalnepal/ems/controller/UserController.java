package com.edigitalnepal.ems.controller;

import com.edigitalnepal.ems.message.ResponseMessage;
import com.edigitalnepal.ems.model.User;
import com.edigitalnepal.ems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseMessage<?>> save(@RequestBody User user) {
        ResponseMessage<?> responseMessage = userService.save(user);
        return new ResponseEntity<ResponseMessage<?>>(responseMessage, HttpStatus.CREATED);
    }

}
