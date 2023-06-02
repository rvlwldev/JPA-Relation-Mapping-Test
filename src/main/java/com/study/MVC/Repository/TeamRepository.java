package com.study.MVC.Repository;

import com.study.DTO.TeamResponse;
import com.study.Entity.Team;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {

//    @Query("SELECT t FROM Team t JOIN FETCH t.members m LEFT JOIN FETCH m.address")
//    Team findByIdWithMembers(@Param("id") int id);

//    @Query("SELECT t FROM Team t JOIN FETCH t.members m WHERE t.id = :id")
//    Team findByIdWithMembers(@Param("id") int id);

    @Query("SELECT m.name " +
            "FROM Member m " +
            "WHERE m.team.id = :id ")
    List<String> findNamesByTeamId(@Param("id") int id);


}
