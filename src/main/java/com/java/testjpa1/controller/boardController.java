package com.java.testjpa1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class boardController {

    @GetMapping("/new")
    public String boardCreate() {
        return "board/boardCreate";
    }

    @GetMapping("/list")
    public String boardList() {
        return "board/boardList";
    }
}
