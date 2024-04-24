package com.dohee.springmybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dohee.springmybatis.dto.Board;
import com.dohee.springmybatis.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<Board> list() {
        List<Board> boardList = boardMapper.list();

        return boardList;
    }

    @Override
    public Board select(int no) {
        Board board = boardMapper.select(no);

        return board;
    }

    @Override
    public int insert(Board board) {

        int result = boardMapper.insert(board);

        return result;
    }

    @Override
    public int update(Board board) {

        int result = boardMapper.update(board);

        return result;
    }

    @Override
    public int delete(int no) {

        int result = boardMapper.delete(no);

        return result;
    }

    @Override
    public int maxPk() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'maxPk'");
    }
    
}
