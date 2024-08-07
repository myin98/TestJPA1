package com.java.testjpa1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class LoginController {

	
    @GetMapping("/login")
    public String login() {
    	return "member/memberLogin";
    }
}
