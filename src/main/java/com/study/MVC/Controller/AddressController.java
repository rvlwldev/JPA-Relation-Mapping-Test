package com.study.MVC.Controller;

import com.study.Entity.Address;
import com.study.MVC.Service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService service;

    AddressController(AddressService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAddress() {
        return ResponseEntity.ok(service.getAddress());
    }
}
