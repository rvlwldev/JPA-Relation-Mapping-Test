package com.study.Entity.PK;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
public class VacationKey implements Serializable {
    private int vacationId;
    private int member;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;

        VacationKey vacation = (VacationKey) o;

        return Objects.equals(getVacationId(), vacation.getVacationId())
                && getMember() == vacation.getMember();
    }

    @Override
    public int hashCode() {
        return Objects.hash(vacationId, member);
    }
}
