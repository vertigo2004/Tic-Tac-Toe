package edu.ukd.oop.tictactoe.ui;

import edu.ukd.oop.tictactoe.GameDispatcher;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class GameSetupPanel extends JPanel {

    private JComboBox<String> playerOneChooser = new JComboBox<>(new String[] {"Людина", "Тупенький", "Розумний", "Геній"});
    private JComboBox<String> playerTwoChooser = new JComboBox<>(new String[] {"Людина", "Тупенький", "Розумний", "Геній"});
    private JButton startGameButton = new JButton("Почати гру");
    private JLabel crossLabel = new JLabel("За Хрестика ->");
    private JLabel noughtLabel = new JLabel("<- За Нолика");

    public GameSetupPanel(GameDispatcher gameDispatcher) {
        super();

        setLayout(new FlowLayout());
        add(crossLabel);
        add(playerOneChooser);
        add(startGameButton);
        add(playerTwoChooser);
        add(noughtLabel);
        setVisible(true);
    }

    public String getPlayerCross() {
        return playerOneChooser.getItemAt(playerOneChooser.getSelectedIndex());
    }

    public String getPlayerNought() {
        return playerTwoChooser.getItemAt(playerTwoChooser.getSelectedIndex());
    }
}
