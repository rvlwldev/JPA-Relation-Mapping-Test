package com.study.MVC.Controller;

import com.study.DTO.TeamResponse;
import com.study.Entity.Team;
import com.study.MVC.Service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {

    private final TeamService service;

    TeamController(TeamService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<TeamResponse> getTeam(@PathVariable("id") int id) {
        return ResponseEntity.ok(service.getTeam(id));
    }

    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        return ResponseEntity.ok(service.saveTeam(team));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Team> deleteTeam(@PathVariable("id") int id) {
        service.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }

}
