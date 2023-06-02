package com.study.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class MemberResponse {
    private String name;
    private String email;
    private String city;
}
