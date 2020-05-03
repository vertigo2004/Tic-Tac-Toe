package edu.ukd.oop.tictactoe.player;

import edu.ukd.oop.tictactoe.Mark;

public class HumanPlayer implements IPlayer {

    @Override
    public int move(Mark[] board) {
//        do nothing
        return -1;
    }

    @Override
    public String toString() {
        return "HumanPlayer";
    }

    @Override
    public boolean isHuman() {
        return true;
    }
}
