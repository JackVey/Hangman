package hangman;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;

public class LoginSingUpPageController {
    //Login page attributes
    @FXML
    private TextField enter_username_textfield;
    @FXML
    private TextField enter_passwrod_textfield;
    @FXML
    private Label login_message;
    //SingUp page attributes
    @FXML
    private TextField enter_name_textfield;
    @FXML
    private TextField choose_username_textfield;
    @FXML
    private TextField choose_password_textfield;
    @FXML
    private TextField re_enter_textfield;
    @FXML
    private Label sing_up_message;
    @FXML
    private void onLoginButtonClick() throws IOException {
        String username = enter_username_textfield.getText();
        String password = enter_passwrod_textfield.getText();
        if (username.isBlank() || username.isEmpty() ||
        password.isEmpty() || password.isBlank()){
            login_message.setText("Please enter the required information");
        }
        else if(Security.validateLoginInfo(username, password)){
            login_message.setText("Login in, pleas wait...");
            Scene scene = new Scene(FXMLLoader.load(HangmanApp.class.getResource("main-menu-page.fxml")));
            HangmanApp.stage.setScene(scene);
        }
        else {
            login_message.setText("Username/Password is wrong!");
        }

    }

    @FXML
    private void onSingUpButtonClick(){
        String enteredName = enter_name_textfield.getText();
        String enteredUsername = choose_username_textfield.getText();
        String enteredPassword = choose_password_textfield.getText();
        String reEnteredPassword = re_enter_textfield.getText();
        if (enteredName.isEmpty() || enteredName.isBlank() ||
                enteredUsername.isEmpty() || enteredUsername.isBlank() ||
                enteredPassword.isEmpty() || enteredPassword.isBlank() ||
                reEnteredPassword.isEmpty() || reEnteredPassword.isBlank()){
            sing_up_message.setText("Please enter all required information");
        } else if (enteredUsername.contains(" ")) {
            sing_up_message.setText("Username cannot contains space!");
        } else if (Security.validateUsername(enteredUsername)) {
            sing_up_message.setText("Username already exist!");
        } else if (!Security.validatePassword(enteredPassword, reEnteredPassword)) {
            sing_up_message.setText("Password and confirmed password are different!");
        }else {
            DatabaseManager.writeSingUpData(enteredUsername, enteredName, enteredPassword);
            sing_up_message.setText("You are singed up!");
        }
    }

}