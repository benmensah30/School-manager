package com.example.schoolmanager.Interface;

import com.example.schoolmanager.models.User;

import java.sql.SQLException;

public interface UserInterface {

    void userLogin(User user) throws SQLException;

}