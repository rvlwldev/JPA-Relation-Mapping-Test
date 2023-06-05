package com.study.MVC.Controller;

import com.study.DTO.EmbeddedVacationResponse;
import com.study.DTO.VacationResponse;
import com.study.MVC.Service.VacationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v")
public class VacationController {

    private final VacationService service;

    VacationController(VacationService service) {
        this.service = service;
    }

    @PostMapping("/test/{id}")
    public ResponseEntity<VacationResponse> testsave(@PathVariable("id") int id) throws IllegalAccessException {
        return ResponseEntity.ok(service.testsave(id));
    }

    @PostMapping("/test2/{id}")
    public ResponseEntity<EmbeddedVacationResponse> testsave2(@PathVariable("id") int id) throws IllegalAccessException {
        return ResponseEntity.ok(service.testsave2(id));
    }
}
