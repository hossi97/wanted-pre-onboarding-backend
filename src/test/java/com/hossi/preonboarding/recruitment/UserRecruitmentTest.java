package com.hossi.preonboarding.recruitment;

import com.hossi.preonboarding.recruitment.entity.Company;
import com.hossi.preonboarding.recruitment.repository.CompanyRepository;
import com.hossi.preonboarding.recruitment.entity.Recruitment;
import com.hossi.preonboarding.recruitment.repository.RecruitmentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayName("사용자 - 채용 공고 목록 조회 / 검색 / 상세 조회 ")
public class UserRecruitmentTest {

    @Autowired
    RecruitmentRepository recruitmentRepository;
    @Autowired
    CompanyRepository companyRepository;

    @Test
    @DisplayName("recruitment join on company 목록 조회")
    public void selectRecruitmentList() {
        Company company = Company.builder()
                .name("원티드")

                .region("한국")
                .build();

        Recruitment recruitment1 = Recruitment.builder()
                .content("채용내용은 다음과 같습니다.")
                .reward(100_000)
                .tech("Java")
                .position("백엔드 개발자")
                .company(company)
                .build();

        Recruitment recruitment2 = Recruitment.builder()
                .content("채용내용은 다음과 같습니다.")
                .reward(100_000)
                .tech("Javascript")
                .position("프론트엔드 개발자")
                .company(company)
                .build();

        recruitmentRepository.save(recruitment1);
        recruitmentRepository.save(recruitment2);
        companyRepository.save(company);

        List<Recruitment> recruitmentList = recruitmentRepository.findAll();
        recruitmentList.forEach(recruitment -> {
            System.out.println(recruitment);
            System.out.println(recruitment.getCompany());
            assertThat(company).isEqualTo(recruitment.getCompany());
        });

    }

}
