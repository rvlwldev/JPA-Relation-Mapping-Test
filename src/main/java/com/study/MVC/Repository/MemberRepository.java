package com.study.MVC.Repository;

import com.study.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    @Query("SELECT m FROM Member m JOIN FETCH m.address")
    List<Member> findAll();

    @Query("SELECT m FROM Member m WHERE m.uid = :id")
    Member select(@Param("id") int id);
}
