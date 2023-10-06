package com.hossi.preonboarding.recruitment;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Recruitment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    @Column(nullable = false, length = 50)
    private String position;

    @Setter
    private Integer reward;

    @Lob
    @Setter
    @Column(nullable = false)
    private String content;

    @Setter
    @Column(nullable = false, length = 50)
    private String tech;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modifiedDate;

    @Builder
    public Recruitment(String position, Integer reward, String content, String tech) {
        this.position = position;
        this.reward = reward;
        this.content = content;
        this.tech = tech;
    }
}
