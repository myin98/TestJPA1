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
    private long id;

    @Column(unique = true, nullable = false)
    private String user_Id;

    @Column(nullable = false)
    private String user_Nm;

    @Column(nullable = false)
    private String user_Pw;

    @Column(length = 255)
    private String user_Email;

    @Column
    @CreationTimestamp
    private LocalDateTime createdate;
    
    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>();
}
