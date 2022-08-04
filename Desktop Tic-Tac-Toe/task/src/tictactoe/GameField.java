package tictactoe;

import tictactoe.enums.Players;
import tictactoe.enums.Status;

import javax.swing.*;
import java.awt.*;

import static tictactoe.Rules.checkRules;
import static tictactoe.TicTacToe.*;
import static tictactoe.enums.Players.getCurrentPlayer;


public class GameField extends JPanel {
    static JLabel statusLabel = new JLabel(TicTacToe.statusGame.getStatusName());
    public static int count = 0;

    public static JPanel createButtonField() {

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout());
        var buttonsField = new JPanel();
        buttonsField.setLayout(new GridLayout(3, 3, 1, 1));
        createButtons(buttonsField);

        var statusField = new JPanel();
        statusField.setLayout(new GridLayout(1, 2, 1, 1));
        var resetButton = new JPanel();
        resetButton.setLayout(new FlowLayout(FlowLayout.LEFT, 147, 5));
        resetButton.add(new JLabel(""));
        resetBtn = new JButton("Reset");
        resetBtn.setName("ButtonReset");
        resetButton.add(resetBtn);
        resetBtn.addActionListener(actionEvent -> checkButton(resetBtn));

        statusLabel.setName("LabelStatus");
        statusField.add(statusLabel);
        statusField.add(resetButton);

        gamePanel.add(buttonsField, BorderLayout.CENTER);
        gamePanel.add(statusField, BorderLayout.SOUTH);

        return gamePanel;
    }

    private static void createButtons(JPanel buttonsField) {
        for (int i = 0; i < aButtons.length; i++) {
            JButton jb = new JButton();
            jb.setName("Button" + buttonNames[i]);
            jb.addActionListener(actionEvent -> checkButton(jb));
            jb.setFocusPainted(false);
            jb.setFont(new Font("Arial", Font.PLAIN, 40));
            jb.setText( " ");
            buttonsField.add(jb);
            aButtons[i] = jb;
        }
    }

    public static void checkButton(JButton jb) {
        if (!jb.getName().equals("ButtonReset")) {
            if(jb.getText().equals(" ") && (statusGame.equals(Status.GAME_IN_PROGRESS) || (statusGame.equals(Status.GAME_IS_NOT_STARTED)))){
                jb.setText(currentPlayer);
                currentPlayer = getCurrentPlayer(currentPlayer);
                checkRules();
                count++;
            }
        } else {
            currentPlayer = String.valueOf(Players.X);
            for (JButton arrayButton : aButtons) {
                arrayButton.setText(" ");
            }
            statusGame = Status.GAME_IS_NOT_STARTED;
            count = 0;
        }
        statusLabel.setText(String.valueOf(statusGame.getStatusName()));
        if (statusGame.equals(Status.GAME_IS_NOT_STARTED)) {
            statusGame = Status.GAME_IN_PROGRESS;
        }

    }



}