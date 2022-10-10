package com.example.SpringCache.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "address")
public class AddressEntity {
    @Id
    @SequenceGenerator(name = "seq_address_id", initialValue = 1, sequenceName = "seq_address_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_address_id")
    private Long id;
    @Column(name = "address_one")
    private String addressOne;
    @Column(name = "address_two")
    private String addressTwo;
    private String city;
    private String state;
    @Column(name = "zip_code")
    private String zipCode;
    @OneToOne(mappedBy = "addressEntity")
    private PersonEntity personEntity;
}
