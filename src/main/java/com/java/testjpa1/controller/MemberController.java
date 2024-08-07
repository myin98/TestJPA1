package com.java.testjpa1.controller;

import com.java.testjpa1.dto.MemberDto;
import com.java.testjpa1.entity.Member;
import com.java.testjpa1.service.MemberService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
    private MemberService ms;

    public MemberController(MemberService memberService) {
        this.ms = memberService;
    }

    @GetMapping("/new")
    public String userCreate(Model model) {
        model.addAttribute("memberDto", new MemberDto());
        return "/member/memberCreate";
    }

    @PostMapping("/new")
    public String create(@Valid MemberDto memberDto, BindingResult result) {

        if (result.hasErrors()) {
            return "/member/memberCreate";
        }

        ms.join(memberDto);
        return "redirect:/member/list";
    }

    @GetMapping("/list")
    public String userList(Model model, MemberDto memberDto) {
    	List<Member> members = ms.findAll();
    	model.addAttribute("members", members);
        return "/member/memberList";
    }
    
    @PostMapping("/list")
    public String userSearch(@RequestParam("id") String user_nm , Model model) {
    	List<Member> memberList = ms.searchMembers(user_nm);
    	
        model.addAttribute("members", memberList);

        return "/member/memberList"; 
    }
    
 
    
}
