package com.java.testjpa1.service;

import com.java.testjpa1.dto.MemberDto;
import com.java.testjpa1.entity.Member;
import com.java.testjpa1.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository mr;

    @Transactional
    public Long join(Member member) {
    	mr.save(member);
        return member.getMember_id();
    }

    private void validateMember(String user_id) {
        if (mr.existsByid(user_id)) {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
    }
    
   public List<Member> findAll(){
	   return mr.findAll();
    }
   
   public List<Member> searchMembers(String user_nm){
	   return mr.findUsersByNameContaining(user_nm);
   }
   
   public Member findById(Long member_id) {
	   return mr.findById(member_id).get();
   }
    
}
