package edu.ukd.oop.tictactoe;

import edu.ukd.oop.tictactoe.player.HumanPlayer;
import edu.ukd.oop.tictactoe.ui.GameFrame;
import edu.ukd.oop.tictactoe.player.IPlayer;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class GameDispatcher {
    private static final String AI_COMMAND = "AI_COMMAND";
    public static int BOARD_SIZE = 3;
    public static int GAME_SIZE = GameDispatcher.BOARD_SIZE * GameDispatcher.BOARD_SIZE;

    private Mark[] board;
    private Mark currentTurn;
    private IPlayer playerCross;
    private IPlayer playerNought;
    private GameFrame frame;
    private int turnCounter;

    public GameDispatcher() {
        board = new Mark[GAME_SIZE];
        currentTurn = Mark.CROSS;
        playerCross = new HumanPlayer();
        playerNought = new HumanPlayer();
        this.frame = new GameFrame(this);
        turnCounter = 0;
    }

    public void processMoveEvent(int move) {

//        1. Put the move mark onto the board.
        board[move] = currentTurn;
//        2. Check the winner condition.
        Mark winner = testWinner();
        if (winner != null) {
//            If the game is over show the information message. Game is over.
            if (winner == Mark.DRAW) {
                JOptionPane.showMessageDialog(frame, "Нічия", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Переміг " + currentTurn, "Game Over", JOptionPane.INFORMATION_MESSAGE);
            }
            frame.getGameBoard().setVisible(false);
//            Game Over
        } else {
//        3. Switch to next player. If it's not a human player:
            currentTurn = currentTurn == Mark.CROSS ? Mark.NOUGHT : Mark.CROSS;
            IPlayer currentPlayer = currentTurn == Mark.CROSS ? playerCross : playerNought;
            if (!currentPlayer.isHuman()) {
//           3.1. Call IPlayer.move() to calculate next plaeyr's move.
                int nextMove = currentPlayer.move(board);
//           3.2. Simulate button click UI action.
                JButton button = frame.getGameBoard().getBoardButton(nextMove);
                button.doClick();
            }
        }
    }

    /**
     * Tests the game position.
     *
     * @return game Mark for winner or draw game. When game is not over returns null.
     */
    private Mark testWinner() {
//        Dumb implementation
        if (++turnCounter < GAME_SIZE) {
            return null;
        } else {
            return Mark.DRAW;
        }
    }

    public Mark getCurrentTurn() {
        return currentTurn;
    }

    public static void main(String[] args) {
        new GameDispatcher();
    }
}
