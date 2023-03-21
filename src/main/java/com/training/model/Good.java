package com.training.model;

import java.util.Objects;

public class Good extends Entity{

    private Integer id;
    private String title;
    private double price;

    public Good(Integer id, String title, double price){
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public Good(String title, double price){
        this.title = title;
        this.price = price;
    }

    public Good(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return id.equals(good.id) &&
                title.equals(good.title) &&
                price == good.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price);
    }
}
