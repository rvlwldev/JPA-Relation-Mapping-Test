package com.study.Entity.PK;

import com.study.Entity.Member;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
public class VacationKey implements Serializable {
    private Integer vacationId;
    private Integer member;
}
