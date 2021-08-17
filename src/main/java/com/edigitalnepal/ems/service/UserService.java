package com.edigitalnepal.ems.service;

import com.edigitalnepal.ems.message.ResponseMessage;
import com.edigitalnepal.ems.model.User;
import com.edigitalnepal.ems.repository.UserRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepositroy userRepositroy;

    public ResponseMessage<?> save(User user) {
        ResponseMessage responseMessage = ResponseMessage.withResponseData(userRepositroy.save(user), "success");
        return responseMessage;
    }
}
