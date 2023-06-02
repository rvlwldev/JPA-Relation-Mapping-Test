package com.study;

import com.study.Entity.PK.VacationKey;
import com.study.Entity.Vacation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudyProjectApplicationTests {

    @Test
    @DisplayName("실제로는 동일한 값을 가진 복합키 객체와 엔티티들을 동등한 것으로 인식해야 한다. ")
    void CompareCompositeIdAndEntity() {
        VacationKey key1 = new VacationKey();
        key1.setVacationId(1);
        key1.setUid(100);

        VacationKey key2 = new VacationKey();
        key2.setVacationId(1);
        key2.setUid(100);

        assertThat(key1.equals(key2)).isTrue();
        assertThat(key2.equals(key1)).isTrue();
        assertThat(key1.hashCode() == key2.hashCode()).isTrue();

        Vacation vacation1 = new Vacation();
        vacation1.setKey(key1);

        Vacation vacation2 = new Vacation();
        vacation2.setKey(key2);

        assertThat(vacation1.equals(vacation2)).isTrue();
        assertThat(vacation2.equals(vacation1)).isTrue();
        assertThat(vacation1.hashCode() == vacation2.hashCode()).isTrue();
    }
}
