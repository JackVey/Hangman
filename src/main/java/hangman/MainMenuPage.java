package hangman;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Objects;

public class MainMenuPage {
    @FXML
    private void onLogoutButtonClick() throws IOException {
        User.logout();
        Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(HangmanApp.class.getResource("login-singup-page.fxml"))));
        HangmanApp.stage.setScene(scene);
    }

    @FXML
    private void onLeaderboardButtonClick() throws IOException {
        Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(HangmanApp.class.getResource("leaderboard-page.fxml"))));
        HangmanApp.stage.setScene(scene);
    }

    @FXML
    private void onGameHistoryButtonClick() throws IOException {
        Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(HangmanApp.class.getResource("player_history.fxml"))));
        HangmanApp.stage.setScene(scene);
    }

    @FXML
    private void onNewGameButtonClick() throws IOException {
        Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(HangmanApp.class.getResource("game-page.fxml"))));
        HangmanApp.stage.setScene(scene);
    }
}
