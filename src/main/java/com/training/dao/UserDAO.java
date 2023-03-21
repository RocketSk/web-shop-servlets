package com.training.dao;

import com.training.model.User;
import com.training.utils.DBConnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO<Integer, User> {

    private final Logger LOGGER = LogManager.getLogger(UserDAO.class.getName());

    @Override
    public List<User> getAll() {
        String sqlStatement = "SELECT * FROM USER_";
        List<User> users = new ArrayList<>();
        try (PreparedStatement statement = DBConnector.getConnection().prepareStatement(sqlStatement);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password")
                ));
            }
        } catch (SQLException e) {
            LOGGER.error("Wrong SQL statement, failed \"getAll()\" operation");
        }
        return users;
    }

    @Override
    public User getById(Integer id) {
        String sqlStatement = "SELECT * FROM USER_ WHERE id = ?";
        User user = new User();
        try(PreparedStatement statement = DBConnector.getConnection().prepareStatement(sqlStatement)){
            statement.setString(1, id.toString());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("login"));
            }
        }catch (SQLException e){
            LOGGER.error("Wrong SQL statement, failed \"getById()\" operation");
        }
        return user;
    }

    @Override
    public User getByLogin(String login){
        String sqlStatement = "SELECT * FROM USER_ WHERE login = ?";
        User user = new User();
        try(PreparedStatement statement = DBConnector.getConnection().prepareStatement(sqlStatement)){
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("login"));
            }
        }catch (SQLException e){
            LOGGER.error("Wrong SQL statement, failed \"getByLogin()\" operation");
        }
        return user;
    }

    @Override
    public void add(User user) {
        String sqlStatement = "INSERT INTO USER_ (id, login, password) VALUES (?,?,?)";
        try(PreparedStatement statement = DBConnector.getConnection().prepareStatement(sqlStatement)){
            statement.setInt(1, user.getId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.addBatch();
            statement.executeUpdate();
        }catch (SQLException e){
            LOGGER.error("Wrong SQL statement, failed \"add()\" operation");
        }
    }
}
