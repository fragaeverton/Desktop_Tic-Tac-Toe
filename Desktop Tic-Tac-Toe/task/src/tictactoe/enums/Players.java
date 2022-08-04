package tictactoe.enums;

public enum Players {
    X, O;

    public static String getCurrentPlayer(String lastPlayer) {
        return (Players.valueOf(lastPlayer) == Players.X) ? String.valueOf(Players.O) : String.valueOf(Players.X);
    }
}