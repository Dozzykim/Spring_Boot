package com.dohee.springmybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dohee.springmybatis.dto.Board;
import com.dohee.springmybatis.service.BoardService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;





@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
    
    @Autowired
    private BoardService boardService;

    /**
     * 게시글 전체 조회
     * @param model
     * @return
     */
    @GetMapping("/list")
    public String list(Model model) {

        List<Board> boardList = boardService.list();

        // 모델에 등록
        model.addAttribute("boardList", boardList);

        log.info("게시글 목록 조회 요청");

        return "board/list";
    }

    /**
     * 게시글 작성 페이지 이동
     * @return
     */
    @GetMapping("/insert")
    public String insert() {

        return "board/insert";
    }

    @PostMapping("/insert")
    public String insertPro(Model model, Board board) {

        int result = boardService.insert(board);

        if (result == 0) {
            // 등록 실패
            return "board/insert";
        }
        
        return "redirect:/board/list";
    }

    /**
     * 게시글 조회 요청
     * @param model
     * @param no
     * @return
     */
    @GetMapping("/read")
    public String read(Model model, @RequestParam("no") int no ) {

        Board board = boardService.select(no);

        model.addAttribute("board", board);

        return "board/read";
    }

    /**
     * 게시글 수정 페이지 이동
     * @param model
     * @param no
     * @return
     */
    @GetMapping("/update")
    public String update(Model model, @RequestParam("no") int no) {
        
        Board board = boardService.select(no);

        model.addAttribute("board", board);       
    
        return "board/update";
    }

    @PostMapping("/update")
    public String updatePro(Board board) {
        
        log.info("컨트롤러 update 함수 진입");

        int result = boardService.update(board);

        if (result == 0) {
            // 실패
            log.info("게시글 수정 실패");
            return "board/update";
        }
        return "redirect:/board/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("no") int no) {

        int result = boardService.delete(no);

        if (result == 0) {
            // 실패
            return "board/read";
        }

        return "redirect:/board/list";
    }

}
