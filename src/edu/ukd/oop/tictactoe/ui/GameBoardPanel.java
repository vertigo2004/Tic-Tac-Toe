package edu.ukd.oop.tictactoe.ui;

import edu.ukd.oop.tictactoe.GameDispatcher;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class GameBoardPanel extends JPanel {
    public static final String POSITION = "POSITION";

    private JButton[] boardButtons = new JButton[GameDispatcher.GAME_SIZE];

    public GameBoardPanel(GameDispatcher gameDispatcher) {
        super();
        setLayout(new GridLayout(GameDispatcher.BOARD_SIZE, GameDispatcher.BOARD_SIZE));

        for (int i = 0; i < GameDispatcher.GAME_SIZE; i++) {
            boardButtons[i] = new JButton();
            boardButtons[i].putClientProperty(POSITION, i);
            add(boardButtons[i]);
        }
        setVisible(true);
    }

    public JButton getBoardButton(int i) {
        return boardButtons[i];
    }
}
