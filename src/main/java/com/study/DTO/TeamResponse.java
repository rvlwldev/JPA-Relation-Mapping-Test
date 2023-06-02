package com.study.DTO;

import com.study.Entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class TeamResponse {
    private String name;
    private MemberResponse manager;
    private List<String> memberNames;
}
