package com.study.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Skill_Code")
public class Skill {

    @Id
    private int code;

    String name;

    @ManyToMany(mappedBy = "skills")
    List<Member> members;

}
