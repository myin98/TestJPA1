package com.java.testjpa1.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.java.testjpa1.dto.BoardDto;
import com.java.testjpa1.entity.Member;
import com.java.testjpa1.entity.Board;
import com.java.testjpa1.repository.BoardRepository;
import com.java.testjpa1.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository br;
	private final MemberRepository mr;
	
	@Transactional
	public Long save(BoardDto boardDto) {
		
		Member mm = findOne(boardDto.getWriter_id());
		if (mm == null) {
			throw new RuntimeException("존재 하지 않는 회원 입니다.");
		}
		Board board = new Board();
		board.setMember(mm);
		board.setTitle(boardDto.getTitle());
		board.setContent(boardDto.getContent());
		br.save(board);
		return board.getBoard_id();
	}
	
	public Member findOne(Long member_id) {
		return mr.findById(member_id).get();
	}
	
	public List<Board> findBoards(){
		return br.findAll();
	}
	
}
