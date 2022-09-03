package tictactoe;

import tictactoe.enums.MenuNames;
import tictactoe.enums.Status;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static tictactoe.Rules.gameOver;
import static tictactoe.TicTacToe.*;
import static tictactoe.TicTacToe.statusGame;

public class ButtonListeners extends GameField{
    public static int countGame = 0;

    public static void listen(JButton jb){
        switch (jb.getText()){
            case START:
                start();
                break;
            case RESET:
                reset();
                break;
            case HUMAN:
            case ROBOT:
                setPlayer(jb);
                break;
            default:
                if(jb.getText().equals(" ") && (statusGame.equals(Status.GAME_IN_PROGRESS))){
                    jb.setText("" +playerTurn.getLetter());
                    if(!checkGameIsOver()){
                        playerTurn = playerTurn.getNumber() == 2 ? players.get(0) : players.get(1);
                        checkRobotTurn(countGame);
                    }
                }
        }
        updateLabel();
        jb.setFocusPainted(false);
    }

    public static void menuListen(ActionEvent e){
        switch (MenuNames.findByText(e.getActionCommand())){
            case HUMAN_HUMAN:
                startFromMenu(new String[]{HUMAN, HUMAN});
                break;
            case HUMAN_ROBOT:
                startFromMenu(new String[]{HUMAN, ROBOT});
                break;
            case ROBOT_HUMAN:
                startFromMenu(new String[]{ROBOT, HUMAN});
                break;
            case ROBOT_ROBOT:
                startFromMenu(new String[]{ROBOT, ROBOT});
                break;
            case EXIT:
                System.exit(0);
                break;
        }
    }

    private static void startFromMenu(String[] s) {
        for(int i =0; i < players.size(); i++){
            players.get(i).setRobot(s[i].equals(ROBOT));
            players.get(i).setText(s[i]);
        }
        playerOneBtn.setText(s[0]);
        playerTwoBtn.setText(s[1]);
        reset();
        start();
    }

    private static boolean checkGameIsOver() {
        boolean isOver = gameOver();
        if(isOver){
            disableButtons(true);
        }
        return isOver;
    }

    public static void start(){
        countGame++;
        statusGame = Status.GAME_IN_PROGRESS;
        resetButton.setText(RESET);
        disableButtons(false);
        playerOneBtn.setEnabled(false);
        playerTwoBtn.setEnabled(false);
        playerTurn = players.get(0);
        checkRobotTurn(countGame);
        updateLabel();
    }
    public static void reset(){
        resetButton.setText(START);
        for (JButton arrayButton : aButtons) {
            arrayButton.setText(" ");
            arrayButton.setEnabled(false);
        }
        playerOneBtn.setEnabled(true);
        playerTwoBtn.setEnabled(true);
        statusGame = Status.GAME_IS_NOT_STARTED;
    }

    private static void checkRobotTurn(int gameNumber) {
        if(playerTurn.getRobot() && (statusGame.equals(Status.GAME_IN_PROGRESS) )){
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            robotMove(gameNumber);
                        }
                    },
                    2500
            );
        }
    }

    private static void robotMove(int gameNumber) {
        List<Integer> availablePositions = new ArrayList<>();
        for(var i =0; i < aButtons.length; i++){
            if(aButtons[i].getText().equals(" ")){
                availablePositions.add(i);
            }
        }
        if(availablePositions.size() > 0 && statusGame.equals(Status.GAME_IN_PROGRESS) && countGame == gameNumber){
            Random randomizer = new Random();
            String random = String.valueOf(availablePositions.get(randomizer.nextInt(availablePositions.size())));
            aButtons[Integer.parseInt(random)].doClick();
        }

    }


    public static void setPlayer(JButton jb){
        boolean isRobot = jb.getText().equals(HUMAN);
        String text = isRobot ? ROBOT : HUMAN;
        jb.setText(text);
        if(jb.getName().equals("ButtonPlayer1")){
            players.get(0).setRobot(isRobot);
            players.get(0).setText(text);
        }else{
            players.get(1).setRobot(isRobot);
            players.get(1).setText(text);
        }
    }
    public static void disableButtons(boolean yes){
        for (JButton arrayButton : aButtons) {
            arrayButton.setEnabled(!yes);
        }
    }
    public static void updateLabel(){
        if (statusGame.equals(Status.GAME_IN_PROGRESS)) {
            statusLabel.setText(String.format("The turn of %s Player (%s)", playerTurn.getText(), playerTurn.getLetter()).trim());
        } else
        if(statusGame.ordinal() > 2){
            statusLabel.setText(String.format("The %s Player (%s) wins", playerTurn.getText(), playerTurn.getLetter()).trim());
        } else{
            statusLabel.setText(statusGame.getStatusName());
        }
    }

}
