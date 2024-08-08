package com.java.testjpa1.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BoardDto {
	
	
	private Long writer_id;
	
	@NotEmpty(message = "제목을 입력하세요.")
	private String title;
	
	@NotEmpty(message = "내용을 입력하세요.")
	private String content;
	
}
