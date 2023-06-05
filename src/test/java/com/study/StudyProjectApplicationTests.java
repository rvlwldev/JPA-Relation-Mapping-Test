package com.study;

import com.study.Entity.Member;
import com.study.Entity.PK.VacationKey;
import com.study.Entity.Vacation;
import com.study.MVC.Repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudyProjectApplicationTests {

    @Autowired
    private MemberRepository memberRepo;

    @Test
    @DisplayName("실제로는 동일한 값을 가진 복합키 객체와 엔티티들을 동등한 것으로 인식해야 한다. ")
    void CompareCompositeIdAndEntity() {
        VacationKey key1 = new VacationKey(1, 1);
        VacationKey key2 = new VacationKey(1, 1);

        Member testmember = memberRepo.findAll().get(0);

        Vacation vacation1 = new Vacation();
        vacation1.setVacationId(1);
        vacation1.setMember(testmember); // Assume Member object with ID 1

        Vacation vacation2 = new Vacation();
        vacation2.setVacationId(1);
        vacation2.setMember(testmember); // Assume Member object with ID 1

        assertThat(key1.equals(key2)).isTrue();
        assertThat(vacation1.equals(vacation2)).isTrue();

        assertEquals(key1.hashCode(), key2.hashCode());
        assertEquals(vacation1.hashCode(), vacation2.hashCode());
    }
}
