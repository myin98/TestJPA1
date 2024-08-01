package com.java.testjpa1.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class MemberDto {

    @NotEmpty(message = "이름을 입력하세요.")
    private String user_nm;

    @NotEmpty(message = "아이디를 입력하세요.")
    private String user_id;

    @NotEmpty(message = "비밀번호를 입력하세요.")
    private String user_pw;

    
    private String user_email;
}
