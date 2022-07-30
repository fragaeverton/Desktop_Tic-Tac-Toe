package tictactoe;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {
    public TicTacToe() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setResizable(false);
        setSize(450, 450);
        setVisible(true);
        setLayout(null);
        setComponent();
    }

    private void setComponent() {

        JButton buttonA3 = new JButton("A3");
        buttonA3.setName("ButtonA3");
        add(buttonA3);

        JButton buttonB3 = new JButton("B3");
        buttonB3.setName("ButtonB3");
        add(buttonB3);

        JButton buttonC3 = new JButton("C3");
        buttonC3.setName("ButtonC3");
        add(buttonC3);

        JButton buttonA2 = new JButton("A2");
        buttonA2.setName("ButtonA2");
        add(buttonA2);

        JButton buttonB2 = new JButton("B2");
        buttonB2.setName("ButtonB2");
        add(buttonB2);

        JButton buttonC2 = new JButton("C2");
        buttonC2.setName("ButtonC2");
        add(buttonC2);

        JButton buttonA1 = new JButton("A1");
        buttonA1.setName("ButtonA1");
        add(buttonA1);

        JButton buttonB1 = new JButton("B1");
        buttonB1.setName("ButtonB1");
        add(buttonB1);

        JButton buttonC1 = new JButton("C1");
        buttonC1.setName("ButtonC1");
        add(buttonC1);

        setLayout(new GridLayout(3, 2, 5, 5));
        setVisible(true);
    }
}