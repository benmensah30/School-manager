package com.example.schoolmanager.models;

import com.example.schoolmanager.IDBConfig.DatabaseDB;
import com.example.schoolmanager.Interface.StudentInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student implements StudentInterface {

    private String nom;

    private String prenom;

    private String naissance;

    private String lieuDeNaissance;

    private String etat;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNaissance() {
        return naissance;
    }

    public void setNaissance(String naissance) {
        this.naissance = naissance;
    }

    public String getLieuDeNaissance() {
        return lieuDeNaissance;
    }

    public void setLieuDeNaissance(String lieuDeNaissance) {
        this.lieuDeNaissance = lieuDeNaissance;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public void studentAdd(Student student) throws SQLException {

        String sql = "INSERT INTO student (firstname, lastname, dateOfBirth, placeOfBirth, state) VALUES (?, ?, ?, ?, ?)";
        Connection connection = DatabaseDB.connectDB();

        assert connection != null;
        PreparedStatement prepStat = connection.prepareStatement(sql);
        prepStat.setString(1, student.getNom());
        prepStat.setString(2, student.getPrenom());
        prepStat.setString(3, student.getNaissance());
        prepStat.setString(4, student.getLieuDeNaissance());
        prepStat.setString(5, student.getEtat());
//                prepStat.setString(6, "info_S.getText()");

        prepStat.executeUpdate();

    }

}
