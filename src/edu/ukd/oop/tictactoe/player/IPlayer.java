package edu.ukd.oop.tictactoe.player;

import edu.ukd.oop.tictactoe.Mark;

public interface IPlayer {

    int move(Mark[] board);

    boolean isHuman();
}
