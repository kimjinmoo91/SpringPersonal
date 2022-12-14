package com.sparta.homework.model;

import com.sparta.homework.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Entity // 테이블임을 나타냅니다.
public class Board extends Timestamped {

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String title;

    @Column(nullable = false)
    private String writeName;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String password;


    public Board(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.writeName = requestDto.getWriteName();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }

    public void update(BoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.writeName = requestDto.getWriteName();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();
    }
}


