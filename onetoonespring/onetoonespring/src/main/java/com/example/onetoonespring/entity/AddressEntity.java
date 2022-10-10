package com.example.onetoonespring.entity;

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

    private String address1;
    private String address2;
    private String city;
    private String state;
    @Column(name = "zip_code")
    private String zipCode;
    @OneToOne(mappedBy = "address")
    private PersonEntity person;

}
