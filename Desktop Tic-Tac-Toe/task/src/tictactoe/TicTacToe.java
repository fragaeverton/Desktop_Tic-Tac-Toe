package tictactoe;

import tictactoe.enums.Status;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TicTacToe extends JFrame {

    public static final String HUMAN = "Human";
    public static final String ROBOT = "Robot";
    public static final String START = "Start";
    public static final String RESET = "Reset";
    public static JButton resetButton, playerOneBtn, playerTwoBtn;
    public static JButton[] aButtons = new JButton[9];
    public static String[] buttonNames  = new String[]{"A3", "B3", "C3", "A2", "B2", "C2", "A1", "B1", "C1"};
    public static List<Player> players = new ArrayList<>();
    public static Player playerTurn;
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
        add(GameField.createFields());
        setVisible(true);
        players.add(new Player(1, 'X', false, HUMAN));
        players.add(new Player(2, 'O', false, HUMAN));
        playerTurn = players.get(0);


    }



}