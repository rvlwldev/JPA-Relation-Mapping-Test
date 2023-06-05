package com.study.Entity;

import com.study.Entity.PK.EmbeddedVacationKey;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "Vacation")
public class EmbeddedVacation {

    @EmbeddedId
    private EmbeddedVacationKey key;

    @ManyToOne
    @JoinColumn(name = "uid", insertable = false, updatable = false)
    private Member member;

    public EmbeddedVacation(EmbeddedVacationKey key) {
        this.key = key;
    }

    public int getVacationId() {
        return this.key.getVacationId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EmbeddedVacation that = (EmbeddedVacation) o;
        return getKey() != null && Objects.equals(getKey(), that.getKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
