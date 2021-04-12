package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "shippers")
public class Shipper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shipperid;
    @Column(nullable = false)
    private String companyname;
    private String phone;

    public int getShipperid() {
        return shipperid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public String getPhone() {
        return phone;
    }

    public void setShipperid(int shipperid) {
        this.shipperid = shipperid;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
