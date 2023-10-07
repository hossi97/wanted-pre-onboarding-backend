package com.hossi.preonboarding.recruitment.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
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

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "recruitment")
    private List<Application> applicationList = new ArrayList<>();

    @Builder
    public Recruitment(String position, Integer reward, String content, String tech, Company company) {
        this.position = position;
        this.reward = reward;
        this.content = content;
        this.tech = tech;
        this.company = company;
    }

    public void setAppliment(Application application) {
        applicationList.add(application);
    }
}
