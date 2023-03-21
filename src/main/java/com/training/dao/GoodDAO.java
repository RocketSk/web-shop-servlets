package com.training.dao;

import com.training.model.Good;
import com.training.utils.DBConnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodDAO extends AbstractDAO<Long, Good> {
    private final Logger LOGGER = LogManager.getLogger(GoodDAO.class.getName());


    @Override
    public List<Good> getAll() {
        String sqlStatement = "SELECT * FROM GOOD";
        List<Good> goods = new ArrayList<>();
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(sqlStatement);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                goods.add(new Good(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        Double.parseDouble(resultSet.getString("price")))
                );
            }
        } catch (SQLException e) {
            LOGGER.error("Wrong SQL statement, failed \"getAll()\" operation");
        }
        return goods;
    }

    @Override
    public Good getById(Long id) {
        String sqlStatement = "SELECT * FROM GOOD WHERE id = ?";
        Good good = new Good();
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(sqlStatement);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                good.setId(resultSet.getInt("id"));
                good.setTitle(resultSet.getString("title"));
                good.setPrice(Double.parseDouble(resultSet.getString("price")));
            }
        } catch (SQLException e) {
            LOGGER.error("Wrong SQL statement, failed \"getById()\" operation");
        }
        return good;
    }

    @Override
    public void add(Good good) {
        String sqlQuery = "INSERT INTO GOOD (id, title, price) VALUES ("
                + good.getId() + " , " + good.getTitle() + " , " + good.getPrice() + ")";
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(sqlQuery)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Wrong SQL statement");
        }
    }

    public void updateGood(Good good) {
        String sqlQuery = "UPDATE good SET name = ? WHERE id = ?";
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(sqlQuery)) {
            statement.setLong(1, good.getId());
            statement.setString(2, good.getTitle());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Wrong SQL statement");
        }
    }

    public void deleteGoodById(Good good) {
        String sqlQuery = "DELETE FROM good WHERE id = ?";
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(sqlQuery)) {
            statement.setLong(1, good.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Wrong SQL statement");
        }
    }
}
