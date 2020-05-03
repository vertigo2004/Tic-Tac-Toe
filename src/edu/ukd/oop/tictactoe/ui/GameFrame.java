package edu.ukd.oop.tictactoe.ui;

import edu.ukd.oop.tictactoe.GameDispatcher;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Container;

public class GameFrame extends JFrame {

    private GameSetupPanel gameSetupPanel;
    private GameBoardPanel gameBoard;
    GameDispatcher gameDispatcher;

    public GameFrame(GameDispatcher gameDispatcher) {
        super("Tic-Tac-Toe Game");
        this.gameDispatcher = gameDispatcher;
        this.gameSetupPanel = new GameSetupPanel(gameDispatcher);
        this.gameBoard = new GameBoardPanel(gameDispatcher);

        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(gameSetupPanel, BorderLayout.NORTH);
        setVisible(true);
    }

    public void newGameBoard() {
        setVisible(false);
        Container cp = getContentPane();
        cp.remove(this.gameBoard);
        this.gameBoard = new GameBoardPanel(gameDispatcher);
        cp.add(this.gameBoard, BorderLayout.CENTER);
        setVisible(true);
    }

    public GameBoardPanel getGameBoard() {
        return gameBoard;
    }

    public GameSetupPanel getGameSetupPanel() {
        return gameSetupPanel;
    }
}
