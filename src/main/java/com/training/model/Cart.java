package com.training.model;

import java.util.ArrayList;
import java.util.List;

public class Cart extends Entity{
    private List<Good> goods;

    public Cart(){
        this.goods = new ArrayList<Good>();
    }

    public List<Good> getGoods() {
        return goods;
    }

    public void addGoods(Good good) {
        goods.add(good);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "goods=" + goods +
                '}';
    }
}
