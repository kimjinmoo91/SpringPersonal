package com.sparta.homework.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String username;
    private String password;

}
// requestDto -> user
// controller 입력 받을 때 쓰는 애
//

