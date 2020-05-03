package edu.ukd.oop.tictactoe;

import edu.ukd.oop.tictactoe.player.HumanPlayer;
import edu.ukd.oop.tictactoe.ui.GameFrame;
import edu.ukd.oop.tictactoe.player.IPlayer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.io.IOException;

public class GameDispatcher {

    public static int BOARD_SIZE = 3;
    public static int GAME_SIZE = GameDispatcher.BOARD_SIZE * GameDispatcher.BOARD_SIZE;

    private Mark[] board;
    private Mark currentTurn;
    private IPlayer playerCross;
    private IPlayer playerNought;
    private GameFrame frame;
    private int turnCounter;
    private final ImageIcon iconCross;
    private final ImageIcon iconNought;

    public GameDispatcher() throws IOException {
        Image imgCross = ImageIO.read(ClassLoader.getSystemResource("resources/cross3.png"));
        iconCross = new ImageIcon(imgCross);
        Image imgNought = ImageIO.read(ClassLoader.getSystemResource("resources/nought3.png"));
        iconNought = new ImageIcon(imgNought);
        this.frame = new GameFrame(this);
    }

    public void newGame() {
        board = new Mark[GAME_SIZE];
        currentTurn = Mark.CROSS;
        playerCross = new HumanPlayer();
        playerNought = new HumanPlayer();
        turnCounter = 0;
        frame.newGameBoard();
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
        Mark result;
//        Test horizontal lines
        for (int i = 0 ; i < BOARD_SIZE; i++) {
            int pos = i * BOARD_SIZE;
            result = board[pos];

            for (int j = 1; result != null && j < BOARD_SIZE; j++) {
                pos = i * BOARD_SIZE + j;
                if (result != board[pos]) {
                    result = null;
                    break;
                }
            }
            if (result != null) {
                return result;
            }
        }

//        Test vertical lines
        for (int i = 0 ; i < BOARD_SIZE; i++) {
            int pos = i;
            result = board[pos];
            for (int j = 1; result !=null && j < BOARD_SIZE; j++) {
                pos = j * BOARD_SIZE + i;
                if (result != board[pos]) {
                    result = null;
                    break;
                }
            }
            if (result != null) {
                return result;
            }
        }

//        Test diagonals
        result = board[0];
        for (int i = 1; i < BOARD_SIZE; i++) {
            int pos = i * BOARD_SIZE + i;
            if (result == null || result != board[pos]) {
                result = null;
                break;
            }
        }
        if (result != null) {
            return result;
        }

        int x = 0;
        int y = 2;
        int pos = x * BOARD_SIZE + y;
        result = board[pos];
        for (int k = 1; k < BOARD_SIZE; k++) {
            pos = ++x * BOARD_SIZE + --y;
            if (result == null || result != board[pos]) {
                result = null;
                break;
            }
        }
        if (result != null) {
            return result;
        }

//        Test draw game
        if (++turnCounter >= GAME_SIZE) {
            result = Mark.DRAW;
        }

        return result;
    }

    public Mark getCurrentTurn() {
        return currentTurn;
    }

    public ImageIcon getIconCross() {
        return iconCross;
    }

    public ImageIcon getIconNought() {
        return iconNought;
    }

    public static void main(String[] args) throws IOException {
        new GameDispatcher();
    }
}
