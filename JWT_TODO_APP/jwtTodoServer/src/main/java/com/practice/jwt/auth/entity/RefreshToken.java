package com.practice.jwt.auth.entity;

import com.practice.jwt.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "REFRESH_TOKEN")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefreshToken {
    
    @Id
    @Column(name = "MEMBER_NO")
    private Long memberNo;
    
    // 일대일 관계를 나타내는 어노테이션 + 지연 로딩 설정(실제 member 객체가 필요할 때만 데이터를 로딩)
    @OneToOne(fetch = FetchType.LAZY)
    // 단방향 관계(RefreshToken -> Member만 참조 가능)
    // 읽기 전용 관계(token.setMember(newMember) 이런 거 안 됨)
    @JoinColumn(name = "MEMBER_NO", insertable = false, updatable = false)
    private Member member;
    
    @Column(name = "REFRESH_TOKEN", nullable = false, length = 500)
    private String token;
    
    @Column(name = "EXPIRATION_DATE", nullable = false)
    private LocalDateTime expirationDate;
    
    // 수정 메서드
    public void update(String token, LocalDateTime expirationDate) {
        this.token = token;
        this.expirationDate = expirationDate;
    }
}
