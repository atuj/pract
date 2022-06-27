package com.rest.pract.component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.rest.pract.models.Mentor;
import com.rest.pract.models.ProgramPractic;
import org.springframework.stereotype.Component;

import com.rest.pract.models.Univers;

@Component
public class ProgramPracticCom {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    private static Connection connection;
    public ProgramPracticCom() {
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
    public static void save(com.rest.pract.models.ProgramPractic programPractic) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO programpractic(ts,description) VALUES(?,?)");
            preparedStatement.setString(1, programPractic.getTs());
            preparedStatement.setString(2, programPractic.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error in DB");
        }
    }

    public static String delete(int id) {
        try {
            PreparedStatement prepared_statement = connection.prepareStatement("DELETE FROM programpractic WHERE idprogram= ? ;");
            prepared_statement.setInt(1, id);
            int result_set = prepared_statement.executeUpdate();
            if (result_set > 0)
            {
                return "deleted";
            }
            else
            {
                return "cant delete";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return " ";
    }

    public static List<ProgramPractic> index() {
        List<ProgramPractic> programPractics = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM programpractic";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                ProgramPractic programPractic = new ProgramPractic();

                programPractic.setIdprogram(resultSet.getInt("idprogram"));
                programPractic.setTs(resultSet.getString("ts"));
                programPractic.setDescription(resultSet.getString("description"));
                System.out.println(programPractic);
                programPractics.add(programPractic);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(programPractics);
        return programPractics;
    }

}
