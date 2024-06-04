package hangman;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class LeaderboardPage implements Initializable {
    @FXML
    private TableView<GameInfo> leaderboard_table;
    @FXML
    private TableColumn<GameInfo, String> username_column;
    @FXML
    private TableColumn<GameInfo, String> word_column;
    @FXML
    private TableColumn<GameInfo, String> wrong_column;
    @FXML
    private TableColumn<GameInfo, String> time_column;
    @FXML
    private void onBackButtonClick() throws IOException {
        Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(HangmanApp.class.getResource("main-menu-page.fxml"))));
        HangmanApp.stage.setScene(scene);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        username_column.setCellValueFactory(new PropertyValueFactory<>("username"));
        word_column.setCellValueFactory(new PropertyValueFactory<>("word"));
        wrong_column.setCellValueFactory(new PropertyValueFactory<>("wrongGuesses"));
        time_column.setCellValueFactory(new PropertyValueFactory<>("time"));

        ArrayList<GameInfo> gameInfos = DatabaseManager.readDataForLeaderboard();

        leaderboard_table.getItems().setAll(gameInfos);
        leaderboard_table.getSortOrder().add(time_column);
    }
}
