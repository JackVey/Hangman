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
}
