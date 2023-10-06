package com.hossi.preonboarding.recruitment.service;

import com.hossi.preonboarding.recruitment.repository.RecruitmentRepository;
import org.springframework.stereotype.Service;

@Service
public class RecruitmentService {
    RecruitmentRepository recruitmentRepository;
    RecruitmentService(RecruitmentRepository recruitmentRepository) {
    }
}
