package hangman;

import java.sql.*;

// Use JDBC to connect to your database and run queries

public class DatabaseManager {
    public static void main(String[] args)  {

        String jdbcUrl = "jdbc:postgresql://localhost:5432/Hangman";
        String username = "postgres";
        String password = "@Dino3386669";


        // Register the PostgreSQL driver


        // Connect to the database

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Perform desired database operations

            // Close the connection
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}