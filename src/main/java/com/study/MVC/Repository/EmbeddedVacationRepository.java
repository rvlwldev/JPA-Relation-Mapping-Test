package com.study.MVC.Repository;

import com.study.Entity.EmbeddedVacation;
import com.study.Entity.Member;
import com.study.Entity.PK.EmbeddedVacationKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmbeddedVacationRepository extends JpaRepository<EmbeddedVacation, EmbeddedVacationKey> {
    List<EmbeddedVacation> findByMember(Member member);
}
