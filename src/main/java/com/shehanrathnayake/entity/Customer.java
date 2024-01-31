package com.shehanrathnayake.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name = "customer")
public class Customer implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 60)
    private String name;
    @Column(nullable = false, length = 20)
    private String phone;
    @Column(nullable = false, length = 500)
    private String address;
}
