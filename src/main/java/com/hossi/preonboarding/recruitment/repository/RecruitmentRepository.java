package com.hossi.preonboarding.recruitment.repository;

import com.hossi.preonboarding.recruitment.entity.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecruitmentRepository extends JpaRepository<Recruitment, Integer> {

    @Query("select r from Recruitment r join fetch r.company c " +
            "where c.name like :keyword " +
            "or c.nation like :keyword " +
            "or c.region like :keyword " +
            "or r.position like :keyword " +
            "or r.content like :keyword " +
            "or r.tech like :keyword "
    )
    List<Recruitment> findAllByKeyword(@Param("keyword") String keyword);

    @Query("select r from Recruitment r join fetch r.company c " +
            "where r.reward = :reward"
    )
    List<Recruitment> findAllByReward(@Param("reward") Integer reward);
}