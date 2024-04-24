package com.dohee.springmybatis.service;

import java.util.List;

import com.dohee.springmybatis.dto.Board;

public interface BoardService {
    
    // 게시글 목록
    public List<Board> list();

    // 게시글 조회
    public Board select(int no);

    // 게시글 등록
    public int insert(Board board);

    // 게시글 수정
    public int update(Board board);

    // 게시글 삭제
    public int delete(int no);

    // 게시글 번호(기본키) 최댓값
    public int maxPk();
    
}
