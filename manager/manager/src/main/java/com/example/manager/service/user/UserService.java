package com.example.manager.service.user;

import com.example.manager.dto.user.UserDto;
import com.example.manager.dto.user.UserLoginDto;
import com.example.manager.repository.user.UserRepository;

public interface UserService {
    //회원가입
    String signUp(UserDto userDto);

    //아이디 중복확인
    String duplicateId(String id);
    //로그인
    String login(UserLoginDto userLoginDto);
}
