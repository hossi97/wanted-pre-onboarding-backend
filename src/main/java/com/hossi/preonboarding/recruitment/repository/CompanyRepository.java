package com.hossi.preonboarding.recruitment.repository;

import com.hossi.preonboarding.recruitment.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
