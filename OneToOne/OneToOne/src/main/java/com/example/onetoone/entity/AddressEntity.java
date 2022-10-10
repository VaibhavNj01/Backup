package com.example.onetoone.entity;

import com.example.onetoone.model.Person;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Data
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

    @OneToOne(mappedBy = "address")
    private PersonEntity person;
}