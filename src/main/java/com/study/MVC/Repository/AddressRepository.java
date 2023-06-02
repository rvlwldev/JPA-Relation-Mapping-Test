package com.study.MVC.Repository;

import com.study.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query("SELECT a FROM Address a JOIN FETCH a.member")
    List<Address> findAll();
}
