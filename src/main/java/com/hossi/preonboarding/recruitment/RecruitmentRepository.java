package com.hossi.preonboarding.recruitment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecruitmentRepository extends JpaRepository<Recruitment, Integer> {
//    List<Recruitment> findByTitleContaining(String keyword);
}
