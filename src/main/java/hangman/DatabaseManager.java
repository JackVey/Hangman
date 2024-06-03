package hangman;

import javax.xml.transform.Result;
import java.sql.*;

// Use JDBC to connect to your database and run queries

public class DatabaseManager {
    private static final String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
    private static final String username = "postgres";
    private static final String password = "@Dino3386669";

    public static String randomAnimalName(){
        String animalName;
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name FROM animals ORDER BY RANDOM() LIMIT 1");
            resultSet.next();
            animalName = resultSet.getString("name");
            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return animalName;
    }
    public static void main(String[] args)  {
        System.out.println(randomAnimalName());
    }
}