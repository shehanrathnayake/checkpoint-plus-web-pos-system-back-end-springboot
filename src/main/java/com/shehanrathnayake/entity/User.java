package com.shehanrathnayake.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 60)
    private String name;
    @Column(nullable = false, length = 100)
    private String password;
    @Column(nullable = false, length = 10)
    private String roles;
}
