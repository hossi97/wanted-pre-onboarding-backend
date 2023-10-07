package com.hossi.preonboarding.recruitment.repository;

import com.hossi.preonboarding.recruitment.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
}
