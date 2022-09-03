package tictactoe;

import tictactoe.enums.MenuNames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static tictactoe.TicTacToe.*;


public class GameField extends JPanel {
    static JLabel statusLabel = new JLabel(TicTacToe.statusGame.getStatusName());

    public static JPanel createFields() {

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout());

        gamePanel.add(createButtonsPanel(), BorderLayout.CENTER);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 1, 1, 1));
        topPanel.add(createMenu());
        topPanel.add(createControlPanel());
        gamePanel.add(topPanel, BorderLayout.NORTH);

        gamePanel.add(createStatusBar(), BorderLayout.SOUTH);

        return gamePanel;
    }

    private static JMenuBar createMenu() {
        List<MenuNames> menuList = new ArrayList<>();
        menuList.add(MenuNames.HUMAN_HUMAN);
        menuList.add(MenuNames.HUMAN_ROBOT);
        menuList.add(MenuNames.ROBOT_HUMAN);
        menuList.add(MenuNames.ROBOT_ROBOT);
        menuList.add(MenuNames.EXIT);
        JMenuBar menuBar = new JMenuBar();
        JMenu menuGame = new JMenu("Game");
        menuGame.setName("MenuGame");
        menuGame.setMnemonic(KeyEvent.VK_G);
        setMenu(menuGame, menuList);
        menuBar.add(menuGame);
        return menuBar;
    }

    private static void setMenu(JMenu menuGame, List<MenuNames> menuList) {
        menuList.forEach((m) -> {
            if(m.equals(MenuNames.EXIT)){
                menuGame.addSeparator();
            }
            JMenuItem menuItem = new JMenuItem(m.getText());
            menuItem.setName(m.getName());
            menuItem.addActionListener(ButtonListeners::menuListen);
            menuGame.add(menuItem);
        });
    }

    private static JPanel createControlPanel() {
        var playersField = new JPanel();
        playersField.setLayout(new GridLayout(1, 3, 1, 1));
        playerOneBtn = new JButton(HUMAN);
        playerOneBtn.setName("ButtonPlayer1");
        playerOneBtn.addActionListener(actionEvent -> ButtonListeners.listen(playerOneBtn));
        playersField.add(playerOneBtn);
        resetButton = new JButton("");
        resetButton.setName("ButtonStartReset");
        resetButton.addActionListener(actionEvent -> ButtonListeners.listen(resetButton));
        playersField.add(resetButton);
        playerTwoBtn = new JButton(HUMAN);
        playerTwoBtn.setName("ButtonPlayer2");
        playerTwoBtn.addActionListener(actionEvent -> ButtonListeners.listen(playerTwoBtn));
        playersField.add(playerTwoBtn);
        ButtonListeners.reset();
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