package com.sparta.homework.dto;

import com.sparta.homework.model.User;
import lombok.Getter;

@Getter
public class UserDto {

    private String email;
    private String username;
    private String password;

    public UserDto(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
