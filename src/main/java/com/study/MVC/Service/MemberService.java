package com.study.MVC.Service;

import com.study.Entity.Member;
import com.study.MVC.Repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository repo;

    MemberService(MemberRepository repo) {
        this.repo = repo;
    }

    public List<Member> getRepo() {
        return repo.findAll();
    }

    public Member getMember(int id) {
        Member res = repo.findById(id)
                .orElseThrow(IllegalAccessError::new);

        System.out.println(res);

        return res;
    }

    public Member saveMember(Member inputMember) {
        inputMember.getAddress().setMember(inputMember);
        return repo.save(inputMember);
    }

    public void deleteMember(int id) {
        repo.deleteById(id);
    }

}
