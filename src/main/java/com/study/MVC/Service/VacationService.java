package com.study.MVC.Service;

import com.study.DTO.MemberResponse;
import com.study.DTO.VacationResponse;
import com.study.Entity.Member;
import com.study.Entity.Vacation;
import com.study.MVC.Repository.MemberRepository;
import com.study.MVC.Repository.VacationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VacationService {

    private final VacationRepository repo;
    private final MemberRepository memberRepo;

    VacationService(VacationRepository repo, MemberRepository memberRepo) {
        this.repo = repo;
        this.memberRepo = memberRepo;
    }

    @Transactional
    public VacationResponse testsave(int id) throws IllegalAccessException {
        Member requestedMember = memberRepo.findById(id)
                .orElseThrow(IllegalAccessException::new);

        Vacation vacation = new Vacation();
        MemberResponse memberResponse = new MemberResponse();
        VacationResponse response = new VacationResponse();

        vacation.setMember(requestedMember);
        vacation.setVacationId(getVacationId(requestedMember));

        memberResponse.setName(requestedMember.getName());
        memberResponse.setCity(requestedMember.getAddress().getCity());
        memberResponse.setEmail(requestedMember.getEmail());

        response.setVacationId(vacation.getVacationId());
        response.setMember(memberResponse);

        return response;
    }

    private int getVacationId(Member requestedMember) {
        List<Vacation> result = repo.findByMember(requestedMember);

        return result.stream()
                .map(Vacation::getVacationId)
                .max(Integer::compareTo)
                .orElse(0) + 1;
    }

}
