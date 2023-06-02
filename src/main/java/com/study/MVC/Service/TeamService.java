package com.study.MVC.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.study.DTO.MemberResponse;
import com.study.DTO.TeamResponse;
import com.study.Entity.Member;
import com.study.Entity.Team;
import com.study.MVC.Repository.MemberRepository;
import com.study.MVC.Repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository repo;
    private final MemberRepository member;

    TeamService(TeamRepository repo, MemberRepository member) {
        this.repo = repo;
        this.member = member;
    }

    @Transactional
    public TeamResponse getTeam(int id) {
        Team team = repo.findById(id)
                .orElseThrow(IllegalAccessError::new);

        MemberResponse manager = new MemberResponse();
        manager.setName(team.getManager().getName());

        TeamResponse res = new TeamResponse();
        res.setName(team.getName());
        res.setManager(manager);
        res.setMemberNames(repo.findNamesByTeamId(id));

        return res;
    }

    @Transactional
    public Team saveTeam(Team team) {
        int id = team.getManager_id();

        Optional<Member> manager = member.findById(id);

        if (manager.isEmpty()) return null;

        team.setManager(manager.get());

        return repo.save(team);
    }

    public void deleteTeam(int id) {
        repo.deleteById(id);
    }
}
