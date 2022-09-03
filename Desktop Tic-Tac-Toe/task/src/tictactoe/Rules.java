package tictactoe;

import tictactoe.enums.Status;

import javax.swing.*;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static tictactoe.TicTacToe.*;

public class Rules {
    public static boolean gameOver() {
        boolean isOver = false;
        if(aButtons[6].getText().equals(aButtons[7].getText()) && aButtons[8].getText().equals(aButtons[6].getText()) && !aButtons[6].getText().equals(" ")){
            statusGame = Status.valueOf(aButtons[6].getText() + "_WINS");
            isOver = true;
        } else
        if(aButtons[3].getText().equals(aButtons[4].getText()) && aButtons[5].getText().equals(aButtons[3].getText()) && !aButtons[3].getText().equals(" ")){
            statusGame = Status.valueOf(aButtons[3].getText() + "_WINS");
            isOver = true;
        } else
        if(aButtons[0].getText().equals(aButtons[1].getText()) && aButtons[2].getText().equals(aButtons[0].getText()) && !aButtons[0].getText().equals(" ")){
            statusGame = Status.valueOf(aButtons[0].getText() + "_WINS");
            isOver = true;
        } else

        if(aButtons[6].getText().equals(aButtons[3].getText()) && aButtons[0].getText().equals(aButtons[6].getText()) && !aButtons[6].getText().equals(" ")){
            statusGame = Status.valueOf(aButtons[6].getText() + "_WINS");
            isOver = true;
        } else
        if(aButtons[7].getText().equals(aButtons[4].getText()) && aButtons[1].getText().equals(aButtons[7].getText()) && !aButtons[7].getText().equals(" ")){
            statusGame = Status.valueOf(aButtons[7].getText() + "_WINS");
            isOver = true;
        } else
        if(aButtons[8].getText().equals(aButtons[5].getText()) && aButtons[2].getText().equals(aButtons[8].getText()) && !aButtons[8].getText().equals(" ")){
            statusGame = Status.valueOf(aButtons[8].getText() + "_WINS");
            isOver = true;
        } else

        if(aButtons[6].getText().equals(aButtons[4].getText()) && aButtons[2].getText().equals(aButtons[6].getText()) && !aButtons[6].getText().equals(" ")){
            statusGame = Status.valueOf(aButtons[6].getText() + "_WINS");
            isOver = true;
        } else

        if(aButtons[0].getText().equals(aButtons[4].getText()) && aButtons[8].getText().equals(aButtons[0].getText()) && !aButtons[0].getText().equals(" ")){
            statusGame = Status.valueOf(aButtons[0].getText() + "_WINS");
            isOver = true;
        } else if(Arrays.stream(aButtons).noneMatch(e -> e.getText().equals(" "))){
            statusGame = Status.DRAW;
            isOver = true;
        }
        return isOver;
    }

}
