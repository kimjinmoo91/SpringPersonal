package com.sparta.homework.repository;

import com.sparta.homework.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


//@Configuration  //  삭제

public interface BoardRepository extends JpaRepository<Board, Long> {
    //findALL All찾고, ByOrderBy 정렬해, ModifiedAt 시간 기준, Desc 내림차순 (최근순)
//    List<Board> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime start, LocalDateTime end);
    List<Board> findAllByUserId(Long userId);
}