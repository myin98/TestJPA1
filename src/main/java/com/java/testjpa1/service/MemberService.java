package com.java.testjpa1.service;

import com.java.testjpa1.dto.MemberDto;
import com.java.testjpa1.entity.Member;
import com.java.testjpa1.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository mr;

    @Transactional
    public Long join(MemberDto memberDto) {
    	Member member = new Member();
    	member.setUser_nm(memberDto.getUser_nm());
        member.setUser_id(memberDto.getUser_id());
        member.setUser_pw(memberDto.getUser_pw());
        member.setUser_email(memberDto.getUser_email());
    	mr.save(member);
        return member.getMember_id();
    }

    private void validateMember(Member member) {
        List<Member> findMembers = mr.findByName(member.getUser_id());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
    }
    
   public List<Member> findAll(){
	   return mr.findAll();
    }
   
   public List<Member> searchMembers(String user_nm){
	   return mr.searchUserId(user_nm);
   }
    
}
