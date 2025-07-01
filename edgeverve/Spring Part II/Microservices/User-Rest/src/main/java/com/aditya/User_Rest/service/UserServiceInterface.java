package com.aditya.User_Rest.service;

import com.aditya.User_Rest.model.ResponseDto;
import com.aditya.User_Rest.model.User;

public interface UserServiceInterface {
    User saveUser(User user);
    User getUserDetail(Long id);
    ResponseDto getUser(Long id);
}
