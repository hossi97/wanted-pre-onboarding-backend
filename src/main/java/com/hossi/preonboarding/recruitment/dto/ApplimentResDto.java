package com.hossi.preonboarding.recruitment.dto;

import com.hossi.preonboarding.recruitment.entity.Member;
import com.hossi.preonboarding.recruitment.entity.Recruitment;

public class ApplimentResDto {
    private final Integer recruitmentId;
    private final Integer memberId;

    public ApplimentResDto(Recruitment recruitment, Member member) {
        recruitmentId = recruitment.getId();
        memberId = member.getId();
    }
}
