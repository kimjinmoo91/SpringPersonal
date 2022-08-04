package com.sparta.homework.controller;

import com.sparta.homework.dto.BoardRequestDto;
import com.sparta.homework.model.Board;
import com.sparta.homework.repository.BoardRepository;
import com.sparta.homework.service.BoardService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RequiredArgsConstructor
@RestController //json 응답
public class BoardController {
    private final BoardRepository boardRepository;


    private final BoardService boardService;


    // PostMapping을 통해서, 같은 주소라도 방식이 다름을 구분합니다.
    // 생성
    @PostMapping("/api/post")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        // requestDto 는, 생성 요청을 의미합니다. createCourse : 생성한 Board 반환
        // 강의 정보를 만들기 위해서는 강의 제목과 튜터 이름이 필요하잖아요?
        // 그 정보를 가져오는 녀석입니다.

        // 저장하는 것은 Dto가 아니라 Board이니, Dto의 정보를 board에 담아야 합니다.
        // 잠시 뒤 새로운 생성자를 만듭니다.
        Board board = new Board(requestDto);
        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
        return boardRepository.save(board);
    }

    @PostMapping("/api/post")
    public String board(@RequestBody Board board) {
        System.out.println(board.getPassword());
        return "board";
    }
    // 조회
    @GetMapping("/api/post")
    public List<Board> getBoards() {
        return boardRepository.findAll();
    }

    @PutMapping("/api/post/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.update(id, requestDto);
    }

    @DeleteMapping("/api/post/{id}")
    public Long deleteBoard(@PathVariable Long id) {
        boardRepository.deleteById(id);
        return id;
    }
}










//        @GetMapping("/boards")
//        public Board getBoards() {
//            Board board = new Board();
//            board.setTitle();
//            board.setWriteName();
//            board.setDate();
//            board.setContent();
//            board.setPassword();
//            return board;
//        }
//    }

