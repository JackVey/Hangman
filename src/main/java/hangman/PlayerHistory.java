package hangman;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class PlayerHistory implements Initializable {
    @FXML
    private TableView<GameInfo> history_table;
    @FXML
    private TableColumn<GameInfo, String> word_column;
    @FXML
    private TableColumn<GameInfo, String> wrong_column;
    @FXML
    private TableColumn<GameInfo, String> time_column;
    @FXML
    private TableColumn<GameInfo, String> win_column;
    @FXML
    private void onBackButtonClick() throws IOException {
        Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(HangmanApp.class.getResource("main-menu-page.fxml"))));
        HangmanApp.stage.setScene(scene);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        word_column.setCellValueFactory(new PropertyValueFactory<>("word"));
        wrong_column.setCellValueFactory(new PropertyValueFactory<>("wrongGuesses"));
        time_column.setCellValueFactory(new PropertyValueFactory<>("time"));
        win_column.setCellValueFactory(new PropertyValueFactory<>("win"));

        ArrayList<GameInfo> gameInfos = DatabaseManager.readGameInfoData(User.getUsername());

        history_table.getItems().setAll(gameInfos);

    }

//    private List<User> parseUserList(){
//        // parse and construct User datamodel list by looping your ResultSet rs
//        // and return the list
//    }
}
