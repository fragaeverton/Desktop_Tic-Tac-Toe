package tictactoe;

import tictactoe.enums.Players;
import tictactoe.enums.Status;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame {
    public static JButton a1, b1, c1, a2, b2, c2, a3, b3, c3, resetBtn;
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