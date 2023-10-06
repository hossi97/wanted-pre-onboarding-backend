package com.hossi.preonboarding.recruitment.dto;

import com.hossi.preonboarding.recruitment.entity.Company;
import com.hossi.preonboarding.recruitment.entity.Recruitment;

public class RecruitmentListResDto {
    private final Integer id;
    private final String name;
    private final String nation;
    private final String region;
    private final String position;
    private final Integer reward;
    private final String tech;

    public RecruitmentListResDto(Recruitment recruitment) {
        Company company = recruitment.getCompany();
        id = recruitment.getId();
        name = company.getName();
        nation = company.getNation();
        region = company.getRegion();
        position = recruitment.getPosition();
        reward = recruitment.getReward();
        tech = recruitment.getTech();
    }
}