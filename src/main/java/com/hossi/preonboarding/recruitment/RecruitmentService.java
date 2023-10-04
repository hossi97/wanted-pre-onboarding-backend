package com.hossi.preonboarding.recruitment;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecruitmentService {
    RecruitmentRepository recruitmentRepository;
    RecruitmentService(RecruitmentRepository recruitmentRepository) {
    }
}
