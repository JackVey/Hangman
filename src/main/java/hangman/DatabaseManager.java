package hangman;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {
    private static final String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
    private static final String username = "postgres";
    private static final String password = "@Dino3386669";

    public static String randomAnimalName() {
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

    public static void writeSingUpData(String targetUsername, String name, String targetPassword) {
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

    public static String readUserInfo(String targetUsername) {
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

    public static void writeGameInfoData(GameInfo gameInfo) {
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            PreparedStatement preparedStatement = connection.prepareStatement("insert into gameinfo (username, word" +
                    ", wrongguesses, time, win ) values (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, gameInfo.getUsername());
            preparedStatement.setString(2, gameInfo.getWord());
            preparedStatement.setInt(3, gameInfo.getWrongGuesses());
            preparedStatement.setInt(4, gameInfo.getTime());
            preparedStatement.setBoolean(5, gameInfo.isWin());

            preparedStatement.executeUpdate();

            // Close the connection
            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<GameInfo> readGameInfoData(String targetUsername) {
        ArrayList<GameInfo> resultArrayList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM gameinfo where username = ?");
            preparedStatement.setString(1, targetUsername);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                GameInfo result = new GameInfo();
                result.setUsername(resultSet.getString("username"));
                result.setWord(resultSet.getString("word"));
                result.setWrongGuesses(resultSet.getInt("wrongguesses"));
                result.setTime(resultSet.getInt("time"));
                result.setWin(resultSet.getBoolean("win"));
                resultArrayList.add(result);
            }

            // Close the connection
            preparedStatement.close();
            resultSet.close();
            connection.close();


        } catch (SQLException e) {

        }

        return resultArrayList;
    }

    public static ArrayList<GameInfo> readDataForLeaderboard() {
        ArrayList<GameInfo> resultArrayList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM gameinfo where win = ?");
            preparedStatement.setBoolean(1, true);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                GameInfo result = new GameInfo();
                result.setUsername(resultSet.getString("username"));
                result.setWord(resultSet.getString("word"));
                result.setWrongGuesses(resultSet.getInt("wrongguesses"));
                result.setTime(resultSet.getInt("time"));
                result.setWin(resultSet.getBoolean("win"));
                resultArrayList.add(result);
            }

            // Close the connection
            preparedStatement.close();
            resultSet.close();
            connection.close();


        } catch (SQLException e) {

        }

        return resultArrayList;
    }

    public static boolean usernameExist(String targetUsername) {
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT username from userinfo Where username = ?");
            preparedStatement.setString(1, targetUsername);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

    }
}