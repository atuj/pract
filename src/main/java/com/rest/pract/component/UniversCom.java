package com.rest.pract.component;

import java.io.Console;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rest.pract.models.Univers;

@Component
public class UniversCom {


    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    private static Connection connection;
    public UniversCom() {
    }


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
    public static void save(Univers univers) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO university(title,course,faculty,specialty) VALUES(?,?,?,?)");
       
            preparedStatement.setString(1, univers.getTitle());
            preparedStatement.setInt(2, univers.getCourse());
            preparedStatement.setString(3, univers.getFaculty());
            preparedStatement.setString(4, univers.getSpecialty());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error in DB");
        }
    }


    //поиск по id
    public static Univers show(int id) {
        Univers univers = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM university WHERE idunivers=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            univers = new Univers();

            univers.setIduniv(resultSet.getInt("idunivers"));
            univers.setTitle(resultSet.getString("title"));
            univers.setCourse(resultSet.getInt("course"));
            univers.setFaculty(resultSet.getString("faculty"));
            univers.setSpecialty(resultSet.getString("specialty"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return univers;
    }

    public static List<Univers> index() {
        List<Univers> people = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM university";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
             Univers univers = new Univers();

            univers.setIduniv(resultSet.getInt("idunivers"));
            univers.setTitle(resultSet.getString("title"));
            univers.setCourse(resultSet.getInt("course"));
            univers.setFaculty(resultSet.getString("faculty"));
            univers.setSpecialty(resultSet.getString("specialty"));
            System.out.println(univers);
                people.add(univers);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(people);
        return people;
    }
    
}
