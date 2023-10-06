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


//{
//	"채용공고_id": 채용공고_id,
//  "회사명":"원티드랩",
//  "국가":"한국",
//  "지역":"서울",
//  "채용포지션":"백엔드 주니어 개발자",
//  "채용보상금":1500000,
//  "사용기술":"Python",
//	"채용내용": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
//	"회사가올린다른채용공고":[채용공고_id, 채용공고_id, ..] # id List **(선택사항 및 가산점요소).**
//}
