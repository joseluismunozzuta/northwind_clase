package com.example.demo.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeID")
    private int id;
    @Column(nullable = false)
    private String lastname;
    private String firstname;
    private String title;
    private String titleofcourtesy;
    private Date birthdate;
    private Date hiredate;
    private String firstname;
    @Lob
    private byte[] picture;
}
