package com.java.testjpa1.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.java.testjpa1.entity.Board;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

	private final EntityManager em;
	
	public void save(Board board) {
		em.persist(board);
	}
	
	public List<Board> findAll(){
		return em.createQuery("select b from Board b",Board.class)
				.getResultList();
	}
	
	
	
}
