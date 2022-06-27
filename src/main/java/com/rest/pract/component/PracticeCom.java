package com.rest.pract.component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.rest.pract.models.Mentor;
import com.rest.pract.models.Practice;
import org.springframework.stereotype.Component;

import com.rest.pract.models.Univers;

@Component
public class PracticeCom {


    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    private static Connection connection;
    public PracticeCom() {}


    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //Фукнция на добавление записи
    public static void save(com.rest.pract.models.Practice practice) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO practice(datestart,datefinish,id_student,id_practicestatus,id_practicedirection) VALUES(?,?,?,?,?)");

            preparedStatement.setDate(1, practice.getDatestart());
            preparedStatement.setDate(2, practice.getDatefinish());
            preparedStatement.setInt(3, practice.getId_student());
            preparedStatement.setInt(4, practice.getId_practicestatus());
            preparedStatement.setInt(5, practice.getId_practicedirection());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error in DB");
        }
    }
    //поиск по id
    public static Practice show(int id) {
        Practice practice = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM practice WHERE idpractice=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            practice = new Practice();
            practice.setIdpractice(resultSet.getInt("idpractice"));
            practice.setDatestart(resultSet.getDate("datestart"));
            practice.setDatefinish(resultSet.getDate("datefinish"));
            practice.setId_student(resultSet.getInt("id_student"));
            practice.setId_practicestatus(resultSet.getInt("id_practicestatus"));
            practice.setId_practicedirection(resultSet.getInt("id_practicedirection"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return practice;
    }

    public static List<Practice> index() {
        List<Practice> practices = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM practice";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Practice practice = new Practice();

                practice.setIdpractice(resultSet.getInt("idpractice"));
                practice.setDatestart(resultSet.getDate("datestart"));
                practice.setDatefinish(resultSet.getDate("datefinish"));
                practice.setId_student(resultSet.getInt("id_student"));
                practice.setId_practicestatus(resultSet.getInt("id_practicestatus"));
                practice.setId_practicedirection(resultSet.getInt("id_practicedirection"));
                System.out.println(practice);
                practices.add(practice);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(practices);
        return practices;
    }

}
