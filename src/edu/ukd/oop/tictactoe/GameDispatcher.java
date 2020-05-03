package edu.ukd.oop.tictactoe;

import edu.ukd.oop.tictactoe.ui.GameFrame;
import edu.ukd.oop.tictactoe.player.IPlayer;

public class GameDispatcher {
    private static final String AI_COMMAND = "AI_COMMAND";
    public static int BOARD_SIZE = 3;
    public static int GAME_SIZE = GameDispatcher.BOARD_SIZE * GameDispatcher.BOARD_SIZE;

    private Mark[] board;
    private Mark currentTurn;
    private IPlayer playerCross;
    private IPlayer playerNought;
    private GameFrame frame;

    public GameDispatcher() {
        board = new Mark[GAME_SIZE];
        currentTurn = Mark.CROSS;
//        todo: Create the IPlayer implementation first. Then instantiate it for both players
//        playerCross =
//        playerNought =
        this.frame = new GameFrame(this);
    }

    public void processMoveEvent(int move) {
//      todo: stub for future implementation
    }

    private Mark testWinner() {
//      todo: stub for future implementation
       return null;
    }

    public Mark getCurrentTurn() {
        return currentTurn;
    }

    public static void main(String[] args) {
        new GameDispatcher();
    }
}
