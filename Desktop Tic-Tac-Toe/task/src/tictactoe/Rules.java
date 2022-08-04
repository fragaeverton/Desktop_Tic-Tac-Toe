package tictactoe;

import tictactoe.enums.Status;

import static tictactoe.GameField.count;
import static tictactoe.TicTacToe.*;

public class Rules {
    public static void checkRules() {
        if(a1.getText().equals(b1.getText()) && c1.getText().equals(a1.getText()) && !a1.getText().equals(" ")){
            statusGame = Status.valueOf(a1.getText() + "_WINS");
        } else
        if(a2.getText().equals(b2.getText()) && c2.getText().equals(a2.getText()) && !a2.getText().equals(" ")){
            statusGame = Status.valueOf(a2.getText() + "_WINS");
        } else
        if(a3.getText().equals(b3.getText()) && c3.getText().equals(a3.getText()) && !a3.getText().equals(" ")){
            statusGame = Status.valueOf(a3.getText() + "_WINS");
        } else

        if(a1.getText().equals(a2.getText()) && a3.getText().equals(a1.getText()) && !a1.getText().equals(" ")){
            statusGame = Status.valueOf(a1.getText() + "_WINS");
        } else
        if(b1.getText().equals(b2.getText()) && b3.getText().equals(b1.getText()) && !b1.getText().equals(" ")){
            statusGame = Status.valueOf(b1.getText() + "_WINS");
        } else
        if(c1.getText().equals(c2.getText()) && c3.getText().equals(c1.getText()) && !c1.getText().equals(" ")){
            statusGame = Status.valueOf(c1.getText() + "_WINS");
        } else

        if(a1.getText().equals(b2.getText()) && c3.getText().equals(a1.getText()) && !a1.getText().equals(" ")){
            statusGame = Status.valueOf(a1.getText() + "_WINS");
        } else

        if(a3.getText().equals(b2.getText()) && c1.getText().equals(a3.getText()) && !a3.getText().equals(" ")){
            statusGame = Status.valueOf(a3.getText() + "_WINS");
        } else if(count == 8){
            statusGame = Status.DRAW;
        }
    }
}
