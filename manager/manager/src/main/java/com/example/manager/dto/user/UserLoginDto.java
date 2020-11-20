package com.example.manager.dto.user;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDto {
    private String id;
    private String passWord;
}
