package com.example.schoolmanager.models;

import com.example.schoolmanager.IDBConfig.DatabaseDB;
import com.example.schoolmanager.Interface.UserInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User implements UserInterface {

    private String email;

    private String password;

    private ResultSet resultSet;

    public ResultSet getResultSet() {
        return resultSet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void userLogin(User user) throws SQLException {

        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
        Connection connection = DatabaseDB.connectDB();

        assert connection != null;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getEmail());
        preparedStatement.setString(2, user.getPassword());

        resultSet = preparedStatement.executeQuery();

    }

}
