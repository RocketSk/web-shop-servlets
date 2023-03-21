package com.training.service.service_impl;

import com.training.model.Cart;
import com.training.model.Good;
import com.training.service.CartService;

public class CartServiceImpl implements CartService {
    @Override
    public String print(Cart cart) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (Good el : cart.getGoods()) {
            sb.append(count + ") " + el.getTitle() + " " + el.getPrice() + " $ </br>");
            count++;
        }
        return sb.toString();
    }

    @Override
    public double getTotalPrice(Cart cart) {
        double count = 0;
        for (Good good : cart.getGoods()) {
            count+=good.getPrice();
        }
        return count;
    }
}
