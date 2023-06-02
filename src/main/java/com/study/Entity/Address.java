package com.study.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "Address")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Address {
    @Id
    int uid;

    String country;
    String city;
    String detail;

    @OneToOne(mappedBy = "address")
    @MapsId
    Member member;

    public void setMember(Member member) {
        this.member = member;
    }
}
