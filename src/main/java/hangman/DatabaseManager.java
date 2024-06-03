package hangman;

import java.sql.*;

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
    public static void writeSingUpData(String targetUsername, String name, String targetPassword){
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            PreparedStatement preparedStatement = connection.prepareStatement("insert into userinfo (name, username, password) values (?, ?, ?)");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, targetUsername);
            preparedStatement.setString(3, targetPassword);

            preparedStatement.executeUpdate();

            // Close the connection
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static String readUserInfo(String targetUsername){
        String result;
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT password FROM userinfo where username = ?");
            preparedStatement.setString(1, targetUsername);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            result = resultSet.getString("password");

            // Close the connection
            preparedStatement.close();
            resultSet.close();
            connection.close();


        } catch (SQLException e) {
            result = "";
        }

        return result;
    }
    public static void writeGameInfoData(String targetUsername, String word, int wrongGuesses, int time, boolean win){
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            PreparedStatement preparedStatement = connection.prepareStatement("insert into gameinfo (username, word" +
                    ", wrongguesses, time, win ) values (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, targetUsername);
            preparedStatement.setString(2, word);
            preparedStatement.setInt(3, wrongGuesses);
            preparedStatement.setInt(4, time);
            preparedStatement.setBoolean(5, win);

            preparedStatement.executeUpdate();

            // Close the connection
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static String readGameInfo(String targetUsername){
        String result;
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT password FROM userinfo where username = ?");
            preparedStatement.setString(1, targetUsername);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            result = resultSet.getString("password");

            // Close the connection
            preparedStatement.close();
            resultSet.close();
            connection.close();


        } catch (SQLException e) {
            result = "";
        }

        return result;
    }
    public static void main(String[] args)  {
        writeGameInfoData("jack", "rabbi", 3, 190, true);
    }
}