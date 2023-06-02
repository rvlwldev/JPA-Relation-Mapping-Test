package com.study.Entity;

import lombok.Getter;
import org.hibernate.annotations.BatchSize;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
public class Team {
    @Id
    @Column(name = "team_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotNull
    String name;


    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    @BatchSize(size = 2)
    List<Member> members;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id")
    Member manager;

    @Transient
    int manager_id;

    public void setManager(Member manager) {
        this.manager = manager;
    }
}
