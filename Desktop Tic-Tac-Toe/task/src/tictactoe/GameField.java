package tictactoe;

import javax.swing.*;
import java.awt.*;

import static tictactoe.TicTacToe.*;


public class GameField extends JPanel {
    static JLabel statusLabel = new JLabel(TicTacToe.statusGame.getStatusName());
    public static int count = 0;

    public static JPanel createFields() {

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout());

        gamePanel.add(createButtonsPanel(), BorderLayout.CENTER);
        gamePanel.add(createControlPanel(), BorderLayout.NORTH);
        gamePanel.add(createStatusBar(), BorderLayout.SOUTH);

        return gamePanel;
    }

    private static JPanel createControlPanel(){
        var playersField = new JPanel();
        playersField.setLayout(new GridLayout(1, 3, 1, 1));
        playerOneBtn = new JButton("Human");
        playerOneBtn.setName("ButtonPlayer1");
        playerOneBtn.addActionListener(actionEvent -> ButtonListeners.listen(playerOneBtn));
        playersField.add(playerOneBtn);
        resetButton = new JButton("");
        resetButton.setName("ButtonStartReset");
        resetButton.addActionListener(actionEvent -> ButtonListeners.listen(resetButton));
        playersField.add(resetButton);
        playerTwoBtn = new JButton("Human");
        playerTwoBtn.setName("ButtonPlayer2");
        playerTwoBtn.addActionListener(actionEvent -> ButtonListeners.listen(playerTwoBtn));
        playersField.add(playerTwoBtn);
        ButtonListeners.reset(resetButton);
        return playersField;

    }

    private static JPanel createButtonsPanel(){
        var buttonsField = new JPanel();
        buttonsField.setLayout(new GridLayout(3, 3, 1, 1));
        createButtons(buttonsField);
        return buttonsField;

    }

    private static JPanel createStatusBar(){
        var statusField = new JPanel();
        statusField.setLayout(new GridLayout(1, 1, 1, 1));
        statusLabel.setName("LabelStatus");
        statusField.add(statusLabel);
        return statusField;

    }

    private static void createButtons(JPanel buttonsField) {
        for (int i = 0; i < aButtons.length; i++) {
            JButton jb = new JButton();
            jb.setName("Button" + buttonNames[i]);
            jb.addActionListener(actionEvent -> ButtonListeners.listen(jb));
            jb.setFont(new Font("Arial", Font.PLAIN, 40));
            jb.setText( " ");
            buttonsField.add(jb);
            aButtons[i] = jb;
        }
    }




}