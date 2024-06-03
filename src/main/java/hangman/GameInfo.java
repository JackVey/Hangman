package hangman;

public class GameInfo {
    private String username;
    private String word;
    private int wrongGuesses;
    private int time;
    private boolean win;

    public String getUsername() {
        return username;
    }

    public String getWord() {
        return word;
    }

    public int getWrongGuesses() {
        return wrongGuesses;
    }

    public int getTime() {
        return time;
    }

    public boolean isWin() {
        return win;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setWrongGuesses(int wrongGuesses) {
        this.wrongGuesses = wrongGuesses;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
}
