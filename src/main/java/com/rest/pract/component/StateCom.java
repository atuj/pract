package com.rest.pract.component;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rest.pract.models.Statemen;


@Component
public class StateCom {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    private static Connection connection;
    public StateCom() {
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





    public static void save(Statemen statement) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO statement(balue,description) VALUES(?,?)");

            preparedStatement.setString(1, statement.getBalue());
            preparedStatement.setString(2, statement.getDescription());
            
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error in DB");
        }
    }

    public static List<Statemen> index() {
        List<Statemen> temp = new ArrayList<>();

        try {
            java.sql.Statement statement =  connection.createStatement();
            String SQL = "SELECT * FROM statement";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Statemen statemen = new Statemen();

                statemen.setIdstate(resultSet.getInt("idstate"));
                statemen.setBalue(resultSet.getString("balue"));
                statemen.setDescription(resultSet.getString("description"));
                

            temp.add(statemen);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return temp;
    }
}
