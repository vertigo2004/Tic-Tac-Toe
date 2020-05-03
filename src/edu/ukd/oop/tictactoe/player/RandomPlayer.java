package edu.ukd.oop.tictactoe.player;

import edu.ukd.oop.tictactoe.GameDispatcher;
import edu.ukd.oop.tictactoe.Mark;

import java.util.Random;

public class RandomPlayer implements IPlayer {

    private Random rand = new Random();

    @Override
    public int move(Mark[] board) {
        int move = rand.nextInt(GameDispatcher.GAME_SIZE);
        for (int i = 0; board[move] != null && i < GameDispatcher.GAME_SIZE; i++) {
            move = (move + 1) % GameDispatcher.GAME_SIZE;
        }
        return move;
    }

    @Override
    public boolean isHuman() {
        return false;
    }

    @Override
    public String toString() {
        return "RandomPlayer";
    }
}
