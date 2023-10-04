package com.hossi.preonboarding.recruitment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class RecruitmentTest {
    @Autowired
    RecruitmentRepository recruitmentRepository;
    @Test
    @DisplayName("recruitment 에 대한 테이블 생성")
    public void createTableOfRecruitment() {
    }

    @Test
    @Transactional
    @DisplayName("recruitment 생성")
    public void createRecruitment() {

        Recruitment recruitment = Recruitment.builder()
                .content("채용내용은 다음과 같습니다.")
                .reward(100_000)
                .tech("Javascript")
                .position("백엔드 개발자")
                .build();

        Recruitment savedRecruitment = recruitmentRepository.save(recruitment);
        Optional<Recruitment> foundedRecruitment = recruitmentRepository.findById(savedRecruitment.getId());

        assertThat(savedRecruitment).isEqualTo(foundedRecruitment.get());
    }

    @Test
    @Transactional
    @DisplayName("recruitment 조회")
    public void selectRecruitment() {
        Recruitment recruitment = Recruitment.builder()
                .content("원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..")
                .reward(100_000)
                .tech("Javascript")
                .position("백엔드 개발자")
                .build();

        Recruitment savedRecruitment = recruitmentRepository.save(recruitment);
        Recruitment foundedRecruitment = recruitmentRepository.findById(savedRecruitment.getId()).get();

        assertThat(savedRecruitment.getContent()).isEqualTo(foundedRecruitment.getContent());
        assertThat(savedRecruitment.getReward()).isEqualTo(foundedRecruitment.getReward());
        assertThat(savedRecruitment.getTech()).isEqualTo(foundedRecruitment.getTech());
        assertThat(savedRecruitment.getPosition()).isEqualTo(foundedRecruitment.getPosition());
    }

    @Test
    @Transactional
    @DisplayName("recruitment 수정")
    public void updateRecruitment() {
        Recruitment recruitment = Recruitment.builder()
                .content("원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..")
                .reward(100_000)
                .tech("Javascript")
                .position("백엔드 개발자")
                .build();

        Recruitment savedRecruitment = recruitmentRepository.save(recruitment);
        Optional<Recruitment> foundedRecruitment = recruitmentRepository.findById(savedRecruitment.getId());

        Recruitment updateRecruitment = foundedRecruitment.get();
        updateRecruitment.setContent("원티드랩에서 백엔드 주니어 개발자를 적극 채용합니다. 자격요건은..");
        updateRecruitment.setTech("Python");
        updateRecruitment.setReward(150_000);
        updateRecruitment.setPosition("데이터 엔지니어");

        Recruitment updatedRecruitment = recruitmentRepository.save(updateRecruitment);

        assertThat(updateRecruitment).isEqualTo(updatedRecruitment);
    }

    @Test
    @Transactional
    @DisplayName("recruitment 삭제")
    public void deleteRecruitment() {
        Recruitment recruitment = Recruitment.builder()
                .content("원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..")
                .reward(100_000)
                .tech("Javascript")
                .position("백엔드 개발자")
                .build();

        Recruitment savedRecruitment = recruitmentRepository.save(recruitment);
        recruitmentRepository.deleteById(savedRecruitment.getId());

        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> {
            recruitmentRepository.findById(savedRecruitment.getId()).get();
        });

    }

}
