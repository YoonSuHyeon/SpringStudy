package com.example.manager.controller.user;


import com.example.manager.dto.user.UserDto;
import com.example.manager.dto.user.UserLoginDto;
import com.example.manager.service.user.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;
    //생성자 주입
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/user/signup") //회원가입
    public String signUp(@RequestBody UserDto userDto) {
        return userService.signUp(userDto);
    }

    @PostMapping("/user/login") //로그인
    public String login(@RequestBody UserLoginDto userLoginDto) {
        return userService.login(userLoginDto);
    }
}
