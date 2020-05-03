package edu.ukd.oop.tictactoe.ui;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class GameBoardPanel extends JPanel {
    public static final String POSITION = "POSITION";

    private JButton[] boardButtons = new JButton[9];

    public GameBoardPanel() {
        super();
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
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
