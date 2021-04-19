package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "`order details`")
public class OrderDetails {

    @EmbeddedId
    OrderDetailsKey id;

    @ManyToOne
    @MapsId("orderid")
    @JoinColumn(name = "orderid")
    private Order order;

    @ManyToOne
    @MapsId("productid")
    @JoinColumn(name = "productid")
    private Product product;

    private double unitprice;
    private int quantity;
    private double discount;

    public OrderDetailsKey getId() {
        return id;
    }

    public void setId(OrderDetailsKey id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}