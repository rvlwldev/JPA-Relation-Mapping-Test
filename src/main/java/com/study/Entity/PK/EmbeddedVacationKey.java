package com.study.Entity.PK;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmbeddedVacationKey implements Serializable {

    @Column(name = "vacation_id")
    private int vacationId;

    private int uid;
}
