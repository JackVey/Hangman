package hangman;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class GamePage implements Initializable {

    private GamePlay gamePlay;
    private ArrayList<Label> letters;
    private ArrayList<ImageView> hangmanParts;

    @FXML
    private Label message_label;

    @FXML
    private HBox letter_container;

    @FXML
    private ImageView head;
    @FXML
    private ImageView body;
    @FXML
    private ImageView right_arm;
    @FXML
    private ImageView left_arm;
    @FXML
    private ImageView right_leg;
    @FXML
    private ImageView left_leg;

    @FXML
    private Button A;
    @FXML
    private Button B;
    @FXML
    private Button C;
    @FXML
    private Button D;
    @FXML
    private Button E;
    @FXML
    private Button F;
    @FXML
    private Button G;
    @FXML
    private Button H;
    @FXML
    private Button I;
    @FXML
    private Button J;
    @FXML
    private Button K;
    @FXML
    private Button L;
    @FXML
    private Button M;
    @FXML
    private Button N;
    @FXML
    private Button O;
    @FXML
    private Button P;
    @FXML
    private Button Q;
    @FXML
    private Button R;
    @FXML
    private Button S;
    @FXML
    private Button T;
    @FXML
    private Button U;
    @FXML
    private Button V;
    @FXML
    private Button W;
    @FXML
    private Button X;
    @FXML
    private Button Y;
    @FXML
    private Button Z;


    @FXML
    private void onBackButtonClick() throws IOException {
        Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(HangmanApp.class.getResource("main-menu-page.fxml"))));
        HangmanApp.stage.setScene(scene);
    }

    @FXML
    private void A() {
        letterButtonsAction("A");
        A.setDisable(true);
    }

    @FXML
    private void B() {
        letterButtonsAction("B");
        B.setDisable(true);
    }

    @FXML
    private void C() {
        letterButtonsAction("C");
        C.setDisable(true);
    }

    @FXML
    private void D() {
        letterButtonsAction("D");
        D.setDisable(true);
    }

    @FXML
    private void E() {
        letterButtonsAction("E");
        E.setDisable(true);
    }

    @FXML
    private void F() {
        letterButtonsAction("F");
        F.setDisable(true);
    }

    @FXML
    private void G() {
        letterButtonsAction("G");
        G.setDisable(true);
    }

    @FXML
    private void H() {
        letterButtonsAction("H");
        H.setDisable(true);
    }

    @FXML
    private void I() {
        letterButtonsAction("I");
        I.setDisable(true);
    }

    @FXML
    private void J() {
        letterButtonsAction("J");
        J.setDisable(true);
    }

    @FXML
    private void K() {
        letterButtonsAction("K");
        K.setDisable(true);
    }

    @FXML
    private void L() {
        letterButtonsAction("L");
        L.setDisable(true);
    }

    @FXML
    private void M() {
        letterButtonsAction("M");
        M.setDisable(true);
    }

    @FXML
    private void N() {
        letterButtonsAction("N");
        N.setDisable(true);
    }

    @FXML
    private void O() {
        letterButtonsAction("O");
        O.setDisable(true);
    }

    @FXML
    private void P() {
        letterButtonsAction("P");
        P.setDisable(true);
    }

    @FXML
    private void Q() {
        letterButtonsAction("Q");
        Q.setDisable(true);
    }

    @FXML
    private void R() {
        letterButtonsAction("R");
        R.setDisable(true);
    }

    @FXML
    private void S() {
        letterButtonsAction("S");
        S.setDisable(true);
    }

    @FXML
    private void T() {
        letterButtonsAction("T");
        T.setDisable(true);
    }

    @FXML
    private void U() {
        letterButtonsAction("U");
        U.setDisable(true);
    }

    @FXML
    private void V() {
        letterButtonsAction("V");
        V.setDisable(true);
    }

    @FXML
    private void W() {
        letterButtonsAction("W");
        W.setDisable(true);
    }

    @FXML
    private void X() {
        letterButtonsAction("X");
        X.setDisable(true);
    }

    @FXML
    private void Y() {
        letterButtonsAction("Y");
        Y.setDisable(true);
    }

    @FXML
    private void Z() {
        letterButtonsAction("Z");
        Z.setDisable(true);
    }


    private void letterButtonsAction(String ch) {
        ArrayList<Integer> indexes = gamePlay.findIndexesOfLetters(ch);
        if (indexes.isEmpty()) {
            hangmanParts.get(gamePlay.getWrongGuesses()).setVisible(true);
            gamePlay.addWrongGuess();
        } else {
            for (int i : indexes) {
                letters.get(i).setText(ch);
            }
        }

        if (gamePlay.checkLoose()) {
            message_label.setText("You Loose!");
            for (int i = 0; i < gamePlay.wordLength(); i++) {
                letters.get(i).setText(String.valueOf(gamePlay.getWord().charAt(i)).toUpperCase());
                letters.get(i).setTextFill(Color.color(1, 0, 0));
            }
            disableAllButtons();
            gamePlay.loose();
        } else if (gamePlay.checkWin()) {
            message_label.setText("You Win!");
            gamePlay.win();
            for (int i = 0; i < gamePlay.wordLength(); i++) {
                letters.get(i).setTextFill(Color.color(0, 1, 0));
            }
            disableAllButtons();
        }
    }

    private void disableAllButtons() {
        A.setDisable(true);
        B.setDisable(true);
        C.setDisable(true);
        D.setDisable(true);
        E.setDisable(true);
        F.setDisable(true);
        G.setDisable(true);
        H.setDisable(true);
        I.setDisable(true);
        J.setDisable(true);
        K.setDisable(true);
        L.setDisable(true);
        M.setDisable(true);
        N.setDisable(true);
        O.setDisable(true);
        P.setDisable(true);
        Q.setDisable(true);
        R.setDisable(true);
        S.setDisable(true);
        T.setDisable(true);
        U.setDisable(true);
        V.setDisable(true);
        W.setDisable(true);
        X.setDisable(true);
        Y.setDisable(true);
        Z.setDisable(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hangmanParts = new ArrayList<>();
        hangmanParts.add(head);
        hangmanParts.add(body);
        hangmanParts.add(right_arm);
        hangmanParts.add(left_arm);
        hangmanParts.add(right_leg);
        hangmanParts.add(left_leg);

        gamePlay = new GamePlay(User.getUsername(), DatabaseManager.randomAnimalName());

        int wordLength = gamePlay.wordLength();

        letters = new ArrayList<>();
        for (int i = 0; i < wordLength; i++) {
            Label label = new Label();
            label.setId("word-letters");
            label.setPrefWidth(65);
            label.setPrefHeight(65);
            letters.add(label);
            letter_container.getChildren().add(label);
            HBox.setMargin(label, new Insets(0, 5, 0, 5));
        }

        gamePlay.pointStartTime();
    }
}
