package hangman;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class GamePlay {
    public GameInfo gameInfo;
    private Instant startTime;
    private Instant endTime;
    private final String word;
    private int wrongGuesses;
    GamePlay(String username, String word){
        this.gameInfo = new GameInfo();
        this.gameInfo.setWord(word);
        this.gameInfo.setUsername(username);
        this.word = word;
    }
    public void pointStartTime(){
        startTime = Instant.now();
    }

    public void pointEndTime(){
        endTime = Instant.now();
    }

    public void setDuration(){
        gameInfo.setTime((int) Duration.between(startTime, endTime).toSeconds());
    }

    public void addWrongGuess(){
        wrongGuesses ++;
    }

    public boolean checkLoose(){
        return wrongGuesses == 6;
    }

    public ArrayList<Integer> findIndexesOfLetters(String ch){
        ArrayList<Integer> indexes = new ArrayList<>();
        String tempWord = word.toUpperCase();
        while (tempWord.contains(ch)){
            indexes.add(tempWord.indexOf(ch));
            tempWord.replace(ch, "*");
        }
        return indexes;
    }
}
