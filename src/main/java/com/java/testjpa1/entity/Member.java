package com.java.testjpa1.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "member")
public class Member {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    @Column(unique = true, nullable = false)
    private String user_id;

    @Column(nullable = false)
    private String user_nm;

    @Column(nullable = false)
    private String user_pw;

    @Column(length = 255)
    private String user_email;

    @Column
    @CreationTimestamp
    private LocalDateTime createdate;
    
    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>();
}
