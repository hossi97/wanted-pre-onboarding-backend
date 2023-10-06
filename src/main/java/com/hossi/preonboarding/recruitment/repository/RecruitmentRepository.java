package com.hossi.preonboarding.recruitment.repository;

import com.hossi.preonboarding.recruitment.entity.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitmentRepository extends JpaRepository<Recruitment, Integer> {
//    List<Recruitment> findByTitleContaining(String keyword);
}
