package hangman;

public class User {
    public static String username;

    User(String username){
        User.username = username;
    }

    public static String getUsername() {
        return username;
    }

    public static void logout(){
        username = "";
    }
}
