package tictactoe;

import tictactoe.enums.Players;
import tictactoe.enums.Status;

import javax.swing.*;
import javax.xml.validation.SchemaFactoryConfigurationError;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        a1 = new JButton();
        b1 = new JButton();
        c1 = new JButton();
        a2 = new JButton();
        b2 = new JButton();
        c2 = new JButton();
        a3 = new JButton();
        b3 = new JButton();
        c3 = new JButton();
        a1.setName("ButtonA1");
        b1.setName("ButtonB1");
        c1.setName("ButtonC1");
        a2.setName("ButtonA2");
        b2.setName("ButtonB2");
        c2.setName("ButtonC2");
        a3.setName("ButtonA3");
        b3.setName("ButtonB3");
        c3.setName("ButtonC3");

        addButtons(buttonsField, a3);
        addButtons(buttonsField, b3);
        addButtons(buttonsField, c3);
        addButtons(buttonsField, a2);
        addButtons(buttonsField, b2);
        addButtons(buttonsField, c2);
        addButtons(buttonsField, a1);
        addButtons(buttonsField, b1);
        addButtons(buttonsField, c1);

        var statusField = new JPanel();
        statusField.setLayout(new GridLayout(1, 2, 1, 1));
        var resetButton = new JPanel();
        resetButton.setLayout(new FlowLayout(FlowLayout.LEFT, 147, 5));
        resetButton.add(new JLabel(""));
        resetBtn = new JButton("Reset");
        resetBtn.setName("ButtonReset");
        resetButton.add(resetBtn);
        setListeners();

        statusLabel.setName("LabelStatus");
        statusField.add(statusLabel);
        statusField.add(resetButton);

        gamePanel.add(buttonsField, BorderLayout.CENTER);
        gamePanel.add(statusField, BorderLayout.SOUTH);

        return gamePanel;
    }


    private static void addButtons(JPanel buttonsField, JButton jButton) {

        jButton.setFocusPainted(false);
        jButton.setFont(new Font("Arial", Font.PLAIN, 40));
        jButton.setText( " ");
        buttonsField.add(jButton);
    }


    private static void setListeners() {
        a1.addActionListener(actionEvent -> checkButton(a1));
        b1.addActionListener(actionEvent -> checkButton(b1));
        c1.addActionListener(actionEvent -> checkButton(c1));
        a2.addActionListener(actionEvent -> checkButton(a2));
        b2.addActionListener(actionEvent -> checkButton(b2));
        c2.addActionListener(actionEvent -> checkButton(c2));
        a3.addActionListener(actionEvent -> checkButton(a3));
        b3.addActionListener(actionEvent -> checkButton(b3));
        c3.addActionListener(actionEvent -> checkButton(c3));
        resetBtn.addActionListener(actionEvent -> checkButton(resetBtn));
    }

    private static void checkButton(JButton jb) {
        if (!jb.getName().equals("ButtonReset")) {
            if(jb.getText().equals(" ") && (statusGame.equals(Status.GAME_IN_PROGRESS) || (statusGame.equals(Status.GAME_IS_NOT_STARTED)))){
                jb.setText(currentPlayer);
                currentPlayer = getCurrentPlayer(currentPlayer);
                checkRules();
                count++;
            }
        } else {
            currentPlayer = String.valueOf(Players.X);
            a1.setText(" ");
            b1.setText(" ");
            c1.setText(" ");
            a2.setText(" ");
            b2.setText(" ");
            c2.setText(" ");
            a3.setText(" ");
            b3.setText(" ");
            c3.setText(" ");
            statusGame = Status.GAME_IS_NOT_STARTED;
            count = 0;
        }
        statusLabel.setText(String.valueOf(statusGame.getStatusName()));
        if (statusGame.equals(Status.GAME_IS_NOT_STARTED)) {
            statusGame = Status.GAME_IN_PROGRESS;
        }

    }



}