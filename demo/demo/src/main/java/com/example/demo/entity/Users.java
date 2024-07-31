package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private int userNo;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "user_pwd", nullable = false)
    private String userPwd;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_birth")
    private Date userBirth;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "user_gender")
    private String userGender;

    public Users(int userNo, String userId, String userPwd, String userName, Date userBirth, String userPhone, String userGender) {
        this.userNo = userNo;
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userBirth = userBirth;
        this.userGender = userGender;
    }
}