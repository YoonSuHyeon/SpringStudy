package com.example.manager.repository.user;

import com.example.manager.dto.user.UserDto;
import com.example.manager.dto.user.UserLoginDto;

import java.util.HashMap;
import java.util.Map;

public class MemoryUserRepository implements  UserRepository {
    private static Map<String, UserDto> store = new HashMap<>();

    //데이터 저장
    @Override
    public void save(UserDto userDto) {
        store.put(userDto.getId(), userDto);
    }

    @Override
    public Object findById(String id) {
        return store.ge
    }
}
