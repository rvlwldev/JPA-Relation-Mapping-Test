package com.study.MVC.Service;

import com.study.DTO.EmbeddedVacationResponse;
import com.study.DTO.MemberResponse;
import com.study.DTO.VacationResponse;
import com.study.Entity.EmbeddedVacation;
import com.study.Entity.Member;
import com.study.Entity.PK.EmbeddedVacationKey;
import com.study.Entity.Vacation;
import com.study.MVC.Repository.EmbeddedVacationRepository;
import com.study.MVC.Repository.MemberRepository;
import com.study.MVC.Repository.VacationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VacationService {

    private final VacationRepository repo;
    private final EmbeddedVacationRepository eRepo;
    private final MemberRepository memberRepo;

    VacationService(VacationRepository repo, EmbeddedVacationRepository eRepo, MemberRepository memberRepo) {
        this.repo = repo;
        this.eRepo = eRepo;
        this.memberRepo = memberRepo;
    }

    @Transactional
    public VacationResponse testsave(int id) throws IllegalAccessException {
        Member requestedMember = memberRepo.findById(id)
                .orElseThrow(IllegalAccessException::new);

        Vacation vacation = new Vacation(getVacationId(requestedMember), requestedMember);

        repo.save(vacation);

        return toResponse(requestedMember, vacation);
    }

    private int getVacationId(Member requestedMember) {
        List<Vacation> result = repo.findByMember(requestedMember);

        return result.stream()
                .map(Vacation::getVacationId)
                .max(Integer::compareTo)
                .orElse(0) + 1;
    }

    private VacationResponse toResponse(Member requestedMember, Vacation vacation) {
        MemberResponse memberResponse = new MemberResponse();
        VacationResponse response = new VacationResponse();

        memberResponse.setName(requestedMember.getName());
        memberResponse.setCity(requestedMember.getAddress().getCity());
        memberResponse.setEmail(requestedMember.getEmail());

        response.setVacationId(vacation.getVacationId());
        response.setMember(memberResponse);

        return response;
    }

    @Transactional
    public EmbeddedVacationResponse testsave2(int id) throws IllegalAccessException {
        Member requestedMember = memberRepo.findById(id)
                .orElseThrow(IllegalAccessException::new);

        EmbeddedVacationKey key = new EmbeddedVacationKey(getEmbeddedVacationId(requestedMember), id);

        EmbeddedVacation vacation = new EmbeddedVacation(key);
        vacation.setMember(requestedMember);

        eRepo.save(vacation);

        return toResponse(requestedMember, vacation);
    }

    private int getEmbeddedVacationId(Member requestedMember) {
        List<EmbeddedVacation> result = eRepo.findByMember(requestedMember);

        return result.stream()
                .map(EmbeddedVacation::getVacationId)
                .max(Integer::compareTo)
                .orElse(0) + 1;
    }

    private EmbeddedVacationResponse toResponse(Member requestedMember, EmbeddedVacation vacation) {
        MemberResponse memberResponse = new MemberResponse();
        EmbeddedVacationResponse response = new EmbeddedVacationResponse();

        memberResponse.setName(requestedMember.getName());
        memberResponse.setCity(requestedMember.getAddress().getCity());
        memberResponse.setEmail(requestedMember.getEmail());

        response.setVacationId(vacation.getKey().getVacationId());
        response.setMember(memberResponse);

        return response;
    }

}
