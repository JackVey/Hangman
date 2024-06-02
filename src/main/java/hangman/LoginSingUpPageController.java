package hangman;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoginSingUpPageController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}