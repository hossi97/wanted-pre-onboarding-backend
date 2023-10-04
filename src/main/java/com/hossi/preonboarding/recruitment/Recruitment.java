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
@Table(name = "recruitment")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Recruitment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Setter
    @Column(name = "position", nullable = false)
    private String position;

    @Setter
    @Column(name = "reward")
    private Integer reward;

    @Setter
    @Column(name = "content", nullable = false)
    private String content;

    @Setter
    @Column(name = "tech", nullable = false)
    private String tech;

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "modified_date", nullable = false)
    private LocalDateTime modifiedDate;

    @Builder
    public Recruitment(String position, Integer reward, String content, String tech) {
        this.position = position;
        this.reward = reward;
        this.content = content;
        this.tech = tech;
    }
}
