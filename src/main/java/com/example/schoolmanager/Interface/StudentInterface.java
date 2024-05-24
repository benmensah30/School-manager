package com.example.schoolmanager.Interface;

import com.example.schoolmanager.models.Student;

import java.sql.SQLException;

public interface StudentInterface {

    void studentAdd(Student student) throws SQLException;

}