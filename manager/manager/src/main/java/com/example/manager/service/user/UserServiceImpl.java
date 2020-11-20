package com.example.manager.service.user;

import com.example.manager.dto.user.UserDto;
import com.example.manager.dto.user.UserLoginDto;
import com.example.manager.repository.user.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements  UserService {
    private final UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;

    }

    @Override
    public String signUp(UserDto userDto) {
        userRepository.save(userDto);
        return "가입";
    }

    @Override
    public String duplicateId(String id) {
        if(userRepository.findById(id)) {
            return "이미 존재하는 아이디";
        }
        return "사용할 수 있는 아이디";
    }

    @Override
    public String login(UserLoginDto userLoginDto) {
       if(userRepository.findByUser(userLoginDto)){
           return "이미 존재하는 아이디";
       }
        return "사용할 수 있는 아이디";
    }
}
