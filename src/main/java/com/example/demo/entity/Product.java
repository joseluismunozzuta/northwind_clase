package com.example.demo.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import javax.validation.constraints.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private int id;

    @NotBlank(message = "No puede estar blanco AHUEVAO")
    @Size(max=40,message = "No pongas mas de 40 caracteres oe TARAO")
    @Column(nullable=false)
    private String productname;

    @Positive(message ="No tienes mamita mano?" )
    @Digits(integer = 10,fraction = 0, message = "No tienes mamita mano?")
    private int supplierid;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    @NotBlank
    private String quantityperunit;

    @Positive
    @Digits(integer = 10, fraction = 4)
    private BigDecimal unitprice;

    @Positive
    @Digits(integer = 10,fraction = 0)
    private int unitsinstock;

    @Positive
    @Digits(integer = 10,fraction = 0)
    private int unitsonorder;

    private int reorderlevel;
    @Column(nullable=false)
    private boolean discontinued;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(int supplierid) {
        this.supplierid = supplierid;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getQuantityperunit() {
        return quantityperunit;
    }

    public void setQuantityperunit(String quantityperunit) {
        this.quantityperunit = quantityperunit;
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    public int getUnitsinstock() {
        return unitsinstock;
    }

    public void setUnitsinstock(int unitsinstock) {
        this.unitsinstock = unitsinstock;
    }

    public int getUnitsonorder() {
        return unitsonorder;
    }

    public void setUnitsonorder(int unitsonorder) {
        this.unitsonorder = unitsonorder;
    }

    public int getReorderlevel() {
        return reorderlevel;
    }

    public void setReorderlevel(int reorderlevel) {
        this.reorderlevel = reorderlevel;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }
}
