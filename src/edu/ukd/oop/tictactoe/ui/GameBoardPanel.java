package edu.ukd.oop.tictactoe.ui;

import edu.ukd.oop.tictactoe.GameDispatcher;
import edu.ukd.oop.tictactoe.Mark;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class GameBoardPanel extends JPanel {
    public static final String POSITION = "POSITION";

    private JButton[] boardButtons = new JButton[GameDispatcher.GAME_SIZE];
    private GameDispatcher dispatcher;

    private ActionListener boardButtonsListener = (e) -> {
        JButton sourceButton = (JButton) e.getSource();
        final ImageIcon imageIcon = dispatcher.getCurrentTurn() == Mark.CROSS
                ? dispatcher.getIconCross()
                : dispatcher.getIconNought();
        sourceButton.setIcon(imageIcon);
        sourceButton.setEnabled(false);
        int buttonPosition = (Integer) sourceButton.getClientProperty(POSITION);
        this.dispatcher.processMoveEvent(buttonPosition);
    };

    public GameBoardPanel(GameDispatcher gameDispatcher) {
        super();
        this.dispatcher = gameDispatcher;

        setLayout(new GridLayout(GameDispatcher.BOARD_SIZE, GameDispatcher.BOARD_SIZE));

        for (int i = 0; i < GameDispatcher.GAME_SIZE; i++) {
            boardButtons[i] = new JButton();
            boardButtons[i].putClientProperty(POSITION, i);
            boardButtons[i].addActionListener(boardButtonsListener);
            add(boardButtons[i]);
        }
        setVisible(true);
    }

    public JButton getBoardButton(int i) {
        return boardButtons[i];
    }
}
