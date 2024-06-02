package hangman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HangmanApp extends Application {
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HangmanApp.class.getResource("login-singup-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setTitle("Hangman");
        stage.setScene(scene);
        stage.show();
        HangmanApp.stage = stage;
    }

    public static void main(String[] args) {
        launch();
    }
}