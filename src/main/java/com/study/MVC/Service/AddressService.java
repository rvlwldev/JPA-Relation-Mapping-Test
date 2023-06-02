package com.study.MVC.Service;

import com.study.Entity.Address;
import com.study.MVC.Repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository repo;

    AddressService(AddressRepository repo) {
        this.repo = repo;
    }

    public List<Address> getAddress() {
        return repo.findAll();
    }
}
