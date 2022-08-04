package com.sparta.homework.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
// 데이터를 물고 다님
public class BoardRequestDto {
    @NotEmpty
    private String title;
    private String writeName;
    private String content;
    private String password;

}