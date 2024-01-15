package com.shehanrathnayake.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name = "customer")
public class Customer implements SuperEntity{
    @Id
    @Column(length = 10)
    private String customerId;
    @Column(nullable = false, length = 60)
    private String name;
    @Column(nullable = false, length = 20)
    private String phone;
    @Column(nullable = false, length = 500)
    private String address;

    public Customer(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
}
