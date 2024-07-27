package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dentists")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_no")
    private int docNo;

    @Column(name = "doc_id", nullable = false, unique = true)
    private String docId;

    @Column(name = "doc_name", nullable = false)
    private String docName;

    @Column(name = "doc_hospital", nullable = false)
    private String docHospital;

    @Column(name = "doc_pwd", nullable = false)
    private String docPwd;

    @Column(name = "doc_phone")
    private String docPhone;

    @Column(name = "doc_mail")
    private String docMail;
}