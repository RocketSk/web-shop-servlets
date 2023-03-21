package com.training.service.service_impl;

import com.training.dao.AbstractDAO;
import com.training.dao.GoodDAO;
import com.training.model.Good;
import com.training.service.GoodService;

import java.util.List;

public class GoodServiceImpl implements GoodService {
    AbstractDAO<Long, Good> dao = new GoodDAO();

    @Override
    public List<Good> getListGoods() {
        return dao.getAll();
    }

    @Override
    public void addGood(Good good) {
        dao.add(good);
    }
}
