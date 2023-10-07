package com.hossi.preonboarding.recruitment;

import com.hossi.preonboarding.recruitment.entity.Application;
import com.hossi.preonboarding.recruitment.entity.Company;
import com.hossi.preonboarding.recruitment.entity.Member;
import com.hossi.preonboarding.recruitment.repository.ApplicationRepository;
import com.hossi.preonboarding.recruitment.repository.CompanyRepository;
import com.hossi.preonboarding.recruitment.entity.Recruitment;
import com.hossi.preonboarding.recruitment.repository.MemberRepository;
import com.hossi.preonboarding.recruitment.repository.RecruitmentRepository;
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
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ApplicationRepository applicationRepository;

    @Test
    @Transactional
    @DisplayName("recruitment 목록 조회")
    public void selectRecruitmentList() {
        Company company = Company.builder()
                .name("원티드")
                .nation("한국")
                .region("서울")
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

    @Test
    @Transactional
    @DisplayName("recruitment 상세 조회")
    public void selectRecruitmentDetail() {
        Company company = Company.builder()
                .name("원티드")
                .nation("한국")
                .region("서울")
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

        company.setRecruitment(recruitment1);
        company.setRecruitment(recruitment2);

        Recruitment savedRecruitment1 = recruitmentRepository.save(recruitment1);
        Recruitment savedRecruitment2 = recruitmentRepository.save(recruitment2);
        Company savedCompany = companyRepository.save(company);

        Recruitment foundedRecruitment1 = recruitmentRepository.findById(savedRecruitment1.getId()).get();
        Recruitment foundedRecruitment2 = recruitmentRepository.findById(savedRecruitment2.getId()).get();
        Company foundedCompany = foundedRecruitment1.getCompany();

        assertThat(recruitment1).isEqualTo(foundedRecruitment1);
        assertThat(savedRecruitment1).isEqualTo(foundedRecruitment1);

        assertThat(company).isEqualTo(foundedCompany);
        assertThat(savedCompany).isEqualTo(foundedCompany);

        List<Recruitment> recruitmentList = company.getRecruitmentList();
        assertThat(recruitmentList.get(0)).isEqualTo(foundedRecruitment1);
        assertThat(recruitmentList.get(1)).isEqualTo(foundedRecruitment2);
    }

    @Test
    @Transactional
    @DisplayName("application 조회")
    public void applyRecruitment() {
        Company company = Company.builder()
                .name("원티드")
                .nation("한국")
                .region("서울")
                .build();

        Recruitment recruitment = Recruitment.builder()
                .content("채용내용은 다음과 같습니다.")
                .reward(100_000)
                .tech("Java")
                .position("백엔드 개발자")
                .company(company)
                .build();

        company.setRecruitment(recruitment);

        Member member = Member.builder()
                .name("홍길동")
                .email("asd1234@domain.com")
                .phoneNum("01000000000")
                .build();

        Company savedCompany = companyRepository.save(company);
        Recruitment savedRecruitment = recruitmentRepository.save(recruitment);
        Member savedMember = memberRepository.save(member);

        Application application = Application.builder()
                .member(savedMember)
                .recruitment(recruitment)
                .build();

        savedMember.setApplication(application);
        savedRecruitment.setAppliment(application);

        Application savedApplication = applicationRepository.save(application);
        Recruitment updatedRecruitment = recruitmentRepository.save(savedRecruitment);
        Member updatedMember = memberRepository.save(savedMember);

        assertThat(updatedRecruitment).isEqualTo(savedApplication.getRecruitment());
        assertThat(updatedMember).isEqualTo(savedApplication.getMember());

    }

}
