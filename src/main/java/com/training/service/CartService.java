package com.training.service;

import com.training.model.Cart;

import java.math.BigDecimal;

public interface CartService {
    String print(Cart cart);

    double getTotalPrice(Cart cart);
}
