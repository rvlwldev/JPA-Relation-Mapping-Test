package com.study.DTO;

import lombok.Data;

@Data
public class EmbeddedVacationResponse {
    private int vacationId;
    private MemberResponse member;
}
