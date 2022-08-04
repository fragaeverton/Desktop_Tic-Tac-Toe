package tictactoe;

import tictactoe.enums.Players;
import tictactoe.enums.Status;

import javax.swing.*;

public class TicTacToe extends JFrame {
    public static JButton  resetBtn;
    public static JButton[] aButtons = new JButton[9];
    public static String[] buttonNames  = new String[]{"A3", "B3", "C3", "A2", "B2", "C2", "A1", "B1", "C1"};
    public static String currentPlayer = String.valueOf(Players.X);
    public static Status statusGame = Status.GAME_IS_NOT_STARTED;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TicTacToe::new);
    }

    public TicTacToe() {
        super("TicTacToe");
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 750);
        setLocationRelativeTo(null);
        add(GameField.createButtonField());
        statusGame = Status.GAME_IN_PROGRESS;

        setVisible(true);
    }



}