package com.training.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Order extends Entity{
    private int id;
    private int userId;
    private double totalPrice;

    public Order(int id, int userId, double totalPrice) {
        this.id = id;
        this.userId = userId;
        this.totalPrice = totalPrice;
    }

    public Order() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                userId == order.userId &&
                totalPrice == order.totalPrice;
    }

    @Override
    public String toString() {
        return "Order {id :" + id + ", total price : " + totalPrice + ", userId : " + userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, totalPrice);
    }
}
