package tictactoe.enums;

import java.util.HashMap;
import java.util.Map;

import static tictactoe.TicTacToe.HUMAN;
import static tictactoe.TicTacToe.ROBOT;

public enum MenuNames {

    HUMAN_HUMAN(HUMAN + " vs " + HUMAN, "Menu" + HUMAN + HUMAN),
    HUMAN_ROBOT(HUMAN + " vs " + ROBOT, "Menu" + HUMAN + ROBOT),
    ROBOT_HUMAN(ROBOT + " vs " + HUMAN, "Menu" + ROBOT + HUMAN),
    ROBOT_ROBOT(ROBOT + " vs " + ROBOT, "Menu" + ROBOT + ROBOT),
    EXIT("Exit", "MenuExit");


    private final String t, n;

    MenuNames(String text, String name){
        t = text;
        n = name;
    }

    public String getText() {
        return t;
    }

    public String getName() {
        return n;
    }

    private static final Map<String, MenuNames> map;
    static {
        map = new HashMap<>();
        for (MenuNames v : MenuNames.values()) {
            map.put(v.t, v);
        }
    }

    public static MenuNames findByText(String key){
        return map.get(key);
    }
}
