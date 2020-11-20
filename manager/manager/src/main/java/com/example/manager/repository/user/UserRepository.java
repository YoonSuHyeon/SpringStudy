package com.example.manager.repository.user;

import com.example.manager.dto.user.UserDto;
import com.example.manager.dto.user.UserLoginDto;

public interface UserRepository {

    void save(UserDto userDto);


    boolean findByUser(UserLoginDto userLoginDto);

    boolean findById(String id);
}
