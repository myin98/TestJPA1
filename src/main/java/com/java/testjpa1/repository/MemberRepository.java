package com.java.testjpa1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.testjpa1.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

	List<Member> findUsersByNameContaining(String user_nm);
	
	boolean existsByid(String user_id);
}
