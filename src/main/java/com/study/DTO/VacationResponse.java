package com.study.DTO;

import lombok.Data;

@Data
public class VacationResponse {
    private int vacationId;
    private MemberResponse member;
}
