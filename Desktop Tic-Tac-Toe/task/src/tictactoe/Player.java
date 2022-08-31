package tictactoe;

public class Player {

    Character letter;
    String text;
    Boolean isRobot;
    Integer number;

    public Player() {
    }

    public Player(Integer number, Character letter, Boolean isRobot, String text) {
        this.number = number;
        this.letter = letter;
        this.isRobot = isRobot;
        this.text = text;
    }

    public Character getLetter() {
        return letter;
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getRobot() {
        return isRobot;
    }

    public void setRobot(Boolean robot) {
        isRobot = robot;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Player{" +
                "letter=" + letter +
                ", text='" + text + '\'' +
                ", isRobot=" + isRobot +
                ", number=" + number +
                '}';
    }
}