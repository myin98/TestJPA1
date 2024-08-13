package com.java.testjpa1.dto;

import com.java.testjpa1.entity.Member;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    @NotEmpty(message = "이름을 입력하세요.")
    private String user_nm;

    @NotEmpty(message = "아이디를 입력하세요.")
    private String user_id;

    @NotEmpty(message = "비밀번호를 입력하세요.")
    private String user_pw;

    
    private String user_email;
    
    public Member toEntity() {
    	return Member.builder()
    			.email(user_email)
    			.userId(user_id)
    			.name(user_nm)
    			.password(user_pw)
    			.build();
    }
}
