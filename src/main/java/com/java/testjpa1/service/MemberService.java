package com.java.testjpa1.service;

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

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        memberRepository.save(member);
        return member.getId();
    }

    private void validateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getUser_Id());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
    }
    
   public List<Member> findAll(){
	   return memberRepository.findAll();
    }
   
   public List<Member> searchMembers(String searchTerm){
	   if (searchTerm == null || searchTerm.trim().isEmpty()) {
		   return findAll();
	   }
	   
	   return memberRepository.searchUserId(searchTerm);
   }
    
}
