package com.java.testjpa1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.testjpa1.entity.Board;
import com.java.testjpa1.entity.Member;

public interface BoardRepository extends JpaRepository<Board, Long> {

	List<Board> findByTitleContaining(String title);
	
	List<Board> findByMember(Member member);
	
}
