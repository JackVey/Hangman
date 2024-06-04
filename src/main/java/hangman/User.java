package hangman;

public class User {
    public static String username;

    public static void setUsername(String username) {
        User.username = username;
    }

    public static String getUsername() {
        return username;
    }

    public static void logout(){
        username = "";
    }
}
