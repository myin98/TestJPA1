package com.java.testjpa1.repository;

import com.java.testjpa1.entity.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public List<Member> findByName(String user_id) {
        return em.createQuery("select m from Member m where m.user_id = :user_id", Member.class)
                .setParameter("user_id", user_id)
                .getResultList();
    }
    
    public List<Member> findAll(){
    	return em.createQuery("select m from Member m", Member.class)
    			.getResultList();
    }
    
    public List<Member> searchUserId(String user_id){
    	return em.createQuery("select m from Member m where m.user_id like :user_id",Member.class)
    			.setParameter("user_id", "%" + user_id + "%")
    			.getResultList();
    }
    

}
