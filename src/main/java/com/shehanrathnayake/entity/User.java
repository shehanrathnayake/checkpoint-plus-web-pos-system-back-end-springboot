package com.shehanrathnayake.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements SuperEntity{
    @Id
    private int id;
    @Column(nullable = false, length = 60)
    private String name;
    @Column(nullable = false, length = 100)
    private String password;
    @Column(nullable = false, length = 10)
    private String roles;
}
