package com.sparta.homework.service;

import com.sparta.homework.dto.BoardRequestDto;
import com.sparta.homework.model.Board;
import com.sparta.homework.repository.BoardRepository;
import com.sparta.homework.dto.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service // 스프링에게 이 클래스는 서비스임을 명시
public class BoardService {

    private final BoardRepository boardRepository;
    // final: 서비스에게 꼭 필요한 녀석임을 명시

//    private final BoardRepository boardRepository;  //final: 이 클래스에 꼭 필요한거야 , 입력후 변형X
//        Board board = boardRepository.findById(id).orElseThrow(
//                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
//        );
//        board.update(requestDto);
//        return id;

    // 생성자를 통해, Service 클래스를 만들 때 꼭 Repository를 넣어주도록
    // 스프링에게 알려줌
    // @NoArgsConstructor -> final이 필요로 하는 정보를 해결,

//    public BoardService(BoardRepository boardRepository) {
//        this.boardRepository = boardRepository; //final 있기 때문에 스프링이 repo에 잘 넣어줌.
//    }

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    // Board 클래스 내 update 메소드를 만들고 변경할 정도를 가져 올 곳에 정보를 바꿔 자동으로 DB에 적용이 됨.=트랜잭션
    public Long update(Long id, BoardRequestDto board) { //update할 정도 id와 가져올 정보 필요.
        Board board1 = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        board1.update(board);
        return board1.getId();
    }
}