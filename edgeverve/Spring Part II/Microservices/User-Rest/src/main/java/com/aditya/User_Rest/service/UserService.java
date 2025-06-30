package com.aditya.User_Rest.service;

import com.aditya.User_Rest.model.DepartmentDto;
import com.aditya.User_Rest.model.ResponseDto;
import com.aditya.User_Rest.model.User;
import com.aditya.User_Rest.model.UserDto;
import com.aditya.User_Rest.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService implements UserServiceInterface{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public ResponseDto getUser(Long id) {
        ResponseDto responseDto = new ResponseDto();
        User user = userRepo.findById(id).get();
        UserDto userDto = mapToUser(user);
        ResponseEntity<DepartmentDto> responseEntity = restTemplate
                .getForEntity("http://localhost:8080/api/departments/" + user.getDepartmentId(), DepartmentDto.class);

        DepartmentDto departmentDto = responseEntity.getBody();
        responseDto.setUserDto(userDto);
        responseDto.setDepartmentDto(departmentDto);
        return responseDto;
    }
}
