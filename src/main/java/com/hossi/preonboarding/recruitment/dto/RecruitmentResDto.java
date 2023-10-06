package com.hossi.preonboarding.recruitment.dto;

import com.hossi.preonboarding.recruitment.entity.Recruitment;
public class RecruitmentResDto {
    private final String position;
    private final String content;
    private final Integer reward;
    private final String tech;

    public RecruitmentResDto(Recruitment recruitment) {
        position = recruitment.getPosition();
        content = recruitment.getContent();
        reward = recruitment.getReward();
        tech = recruitment.getTech();
    }
}
