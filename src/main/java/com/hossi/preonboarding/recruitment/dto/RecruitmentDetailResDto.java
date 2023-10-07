package com.hossi.preonboarding.recruitment.dto;

import com.hossi.preonboarding.recruitment.entity.Company;
import com.hossi.preonboarding.recruitment.entity.Recruitment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecruitmentDetailResDto {
    private final Integer id;
    private final String name;
    private final String nation;
    private final String region;
    private final String position;
    private final String content;
    private final Integer reward;
    private final String tech;
    private final List<Integer> recruitmentIdList;

    public RecruitmentDetailResDto(Recruitment recruitment) {
        Company company = recruitment.getCompany();
        id = company.getId();
        name = company.getName();
        nation = company.getNation();
        region = company.getRegion();
        content = recruitment.getContent();
        position = recruitment.getPosition();
        reward = recruitment.getReward();
        tech = recruitment.getContent();
        recruitmentIdList = company.getRecruitmentList().stream()
                .map(Recruitment::getId).collect(Collectors.<Integer>toList());
    }
}