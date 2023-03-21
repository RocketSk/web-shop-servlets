package com.training.service;

import com.training.model.Good;

import java.util.List;

public interface GoodService {
    List<Good> getListGoods();

    void addGood(Good good);
}
