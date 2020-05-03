package edu.ukd.oop.tictactoe;

import edu.ukd.oop.tictactoe.player.HumanPlayer;
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
        playerCross = new HumanPlayer();
        playerNought = new HumanPlayer();
        this.frame = new GameFrame(this);
    }

    public void processMoveEvent(int move) {
//      todo: implementation steps:
//        1. Put the move mark onto the board.
//        2. Check the winner condition. If the game is over show the information message. Game is over.
//        3. Switch to next player. If it's not a human player:
//           3.1. Call IPlayer.move() to calculate next plaeyr's move.
//           3.2. Simulate button click UI action.
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
