package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderid;
    private String customerid;

    @ManyToOne
    @JoinColumn(name = "employeeid")
    private Employee employee;


    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getOrderid() {
        return orderid;
    }
}
