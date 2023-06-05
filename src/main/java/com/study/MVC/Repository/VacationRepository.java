package com.study.MVC.Repository;

import com.study.Entity.Member;
import com.study.Entity.PK.VacationKey;
import com.study.Entity.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacationRepository extends JpaRepository<Vacation, VacationKey> {

    List<Vacation> findByMember(Member member);

}
