package com.study.MVC.Controller;

import com.study.Entity.Member;
import com.study.MVC.Service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService service;

    MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Member>> getMember() {
        return ResponseEntity.ok(service.getRepo());
    }

    @GetMapping("{id}")
    public ResponseEntity<Member> getMember(@PathVariable("id") int id) {
        return ResponseEntity.ok(service.getMember(id));
    }

    @PostMapping
    public ResponseEntity<Member> saveMember(@RequestBody Member member) {
        return ResponseEntity.ok(service.saveMember(member));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Member> deleteMember(@PathVariable("id") int id) {
        service.deleteMember(id);
        return ResponseEntity.noContent().build();
    }



}
