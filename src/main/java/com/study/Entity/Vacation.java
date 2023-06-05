package com.study.Entity;

import com.study.Entity.PK.VacationKey;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@IdClass(VacationKey.class)
public class Vacation {

    @Id
    @Column(name = "vacation_id")
    private Integer vacationId;

    @Id
    @ManyToOne
    @JoinColumn(name = "uid")
    private Member member;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Vacation vacation = (Vacation) o;
        return getVacationId() != null && Objects.equals(getVacationId(), vacation.getVacationId())
                && getMember() != null && Objects.equals(getMember(), vacation.getMember());
    }

    @Override
    public int hashCode() {
        return Objects.hash(vacationId, member.getUid());
    }
}
