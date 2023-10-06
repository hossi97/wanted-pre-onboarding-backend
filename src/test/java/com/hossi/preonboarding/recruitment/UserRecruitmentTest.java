package com.hossi.preonboarding.recruitment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayName("사용자 - 채용 공고 목록 조회 / 검색 / 상세 조회 ")
public class UserRecruitmentTest {

    @Autowired
    RecruitmentRepository recruitmentRepository;

    @Test
    @DisplayName("recruitment join on company 목록 조회")
    public void selectRecruitmentList() {

    }

}
