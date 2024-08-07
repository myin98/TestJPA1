package com.java.testjpa1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.testjpa1.dto.BoardDto;
import com.java.testjpa1.entity.Board;
import com.java.testjpa1.service.BoardService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")

public class boardController {

	@Autowired
	private BoardService bs;
	
    @GetMapping("/new")
    public String boardCreate(Model model) {
    	model.addAttribute("boardDto", new BoardDto());
        return "board/boardCreate";
    }
    
    @PostMapping("/new")
    private String create(@Valid BoardDto boardDto, BindingResult result) {
    	if (result.hasErrors()) {
    		return "board/boardCreate";
    	}
    	bs.save(boardDto);
    	return "redirect:/board/list";
    }
    
    
    @GetMapping("/list")
    public String boardList(Model model) {
    	List<Board> boards = bs.findBoards();
    	model.addAttribute("boards", boards);
        return "board/boardList";
    }
}
