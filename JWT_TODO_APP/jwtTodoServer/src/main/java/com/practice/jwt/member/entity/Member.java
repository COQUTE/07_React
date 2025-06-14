package com.practice.jwt.member.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @Entity
 * - 이 클래스가 JPA 엔티티임을 나타내는 어노테이션
 * - DB의 테이블과 매핑되어서, 이 클래스 객체가 DB 레코드(행) 하나와 대응됨.
 *  	즉, JPA가 이 클래스를 보고 DB와 연동할 테이블로 인식함.
 *
 * @Table(name = "MEMBER")
 * - 이 엔티티가 매핑될 DB 테이블 이름을 지정
 */

// DB 테이블과 직접 연결되는 영속 엔티티
@Entity
@Table(name = "MEMBER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성을 데이터베이스에 위임하는 전략을 설정
    private Long memberNo;
    
    @Column(unique = true, nullable = false) // UNIQUE, NOT NULL
    private String email;
    
    @Column(nullable = false) // NOT NULL
    private String password; // 암호화된 비밀번호 저장
    
    @Column(nullable = false)
    private String name;
}
