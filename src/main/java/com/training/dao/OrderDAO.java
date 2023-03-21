package com.training.dao;

import com.training.model.Order;
import com.training.utils.DBConnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OrderDAO extends AbstractDAO <Integer, Order>{
    private final Logger LOGGER = LogManager.getLogger(OrderDAO.class.getName());

    @Override
    public List<Order> getAll() {
        String sqlStatement = "SELECT * FROM USER_ORDER";
        List<Order> orders = new ArrayList<>();
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(sqlStatement);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                orders.add(new Order(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        Double.parseDouble(resultSet.getString("total_price"))
                ));
            }
        } catch (SQLException e) {
            LOGGER.error("Wrong SQL statement, failed \"getAll()\" operation");
        }
        return orders;
    }

    @Override
    public Order getById(Integer id) {
        String sqlStatement = "SELECT * FROM USER_ORDER WHERE user_id = ?";
        Order order = new Order();
        try(PreparedStatement statement = DBConnector.getConnection().prepareStatement(sqlStatement)){
            statement.setString(1, id.toString());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                order.setId(resultSet.getInt("id"));
                order.setTotalPrice(Double.parseDouble(resultSet.getString("total_price")));
            }
        }catch (SQLException e){
            LOGGER.error("Wrong SQL statement, failed \"getById()\" operation");
        }
        return order;
    }

    @Override
    public void add(Order order) {
        String sqlStatement = "INSERT INTO USER_ORDER (user_id, total_price) VALUES (?, ?)";
        try(PreparedStatement statement = DBConnector.getConnection().prepareStatement(sqlStatement)){
            statement.setInt(1, order.getUserId());
            statement.setDouble(2, order.getTotalPrice());
            statement.executeUpdate();
        }catch (SQLException e){
            LOGGER.error("Wrong SQL statement, failed \"add()\" operation");
        }
    }
}