package com.example.cartanditem.entity;

import com.example.cartanditem.model.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cart")
public class CartEntity {
    @Id
    @SequenceGenerator(name = "seq_cart_id", initialValue = 1, sequenceName = "seq_cart_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cart_id")
    @Column(name = "cart_Id")
    private Long cartId;
    @Column(name = "cart_name")
    private String cartName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private List<ItemEntity> items;

}
