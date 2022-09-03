package tictactoe.enums;

public enum Status {
    GAME_IS_NOT_STARTED("Game is not started"),
    GAME_IN_PROGRESS("Game in progress"),
    DRAW("Draw"),
    X_WINS("X wins"),
    O_WINS("O wins");

    private final String s;
    Status(String val) {
        s = val;
    }

    public String getStatusName() {
        return s;
    }
}