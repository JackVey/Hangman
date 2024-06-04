package hangman;

public class Security {
    public static boolean validateLoginInfo(String providedUsername, String providedPassword){
        String fetchedPassword = DatabaseManager.readUserInfo(providedUsername);
        if (fetchedPassword.isEmpty()){
            return false;
        }
        if (fetchedPassword.equals(providedPassword)){
            return true;
        }
        return false;
    }

    public static boolean validateUsername(String providedUsername){
        return DatabaseManager.usernameExist(providedUsername);
    }

    public static boolean validatePassword(String password, String reEnteredPassword){
        return password.equals(reEnteredPassword);
    }
}
