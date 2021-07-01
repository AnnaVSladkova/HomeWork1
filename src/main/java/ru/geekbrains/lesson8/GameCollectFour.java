package ru.geekbrains.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameCollectFour extends JFrame {

    private int winWidth = 750;
    private int halfWinWidth = winWidth / 2;
    private int winHeight = 600;
    private int halfHeight = winHeight / 2;
    private int winPosX = 200;
    private int winPosY = 150;


    private final int WinLength = 4;

    private JPanel panelSettings;
    private JPanel panelControls;

    private JButton btnStart;
    private JButton btnReStart;
    private JButton btnExit;
    private JButton btnClearLog;

    private JTextArea gameLog;
    private JScrollPane scrollPanel;

    private GameMap gameMap;

    private int round = 0;

    public GameCollectFour() {
        prepareWindowSettings();

        prepareGameSettings();

        prepareButtons();

        prepareControls();

        prepareGameLog();

        gameMap = new GameMap(this);

        panelSettings.add(panelControls, BorderLayout.NORTH);
        panelSettings.add(scrollPanel, BorderLayout.SOUTH);

        add(panelSettings, BorderLayout.EAST);
        add(gameMap);

        setVisible(true);
    }

    private void prepareGameSettings() {
        panelSettings = new JPanel();
        panelSettings.setLayout(new GridLayout(2, 1));
    }

    private void prepareControls() {
        panelControls = new JPanel();
        panelControls.setLayout(new GridLayout(7, 1));
        panelControls.add(btnStart);
        panelControls.add(btnReStart);
        panelControls.add(btnExit);
        panelControls.add(btnClearLog);
    }

    private void prepareWindowSettings() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(winWidth, winHeight);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int) screenSize.getWidth() / 2 - halfWinWidth, (int) screenSize.getHeight() / 2 - halfHeight);
        setTitle("Игра Собери четыре");
        setResizable(false);
    }

    private void prepareButtons() {
        btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collectAllGameSetupFromUser();
            }
        });
        btnReStart = new JButton("ReStart");
        btnReStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameMap.resetGame();
            }
        });

        btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnClearLog = new JButton("Clear Log");
        btnClearLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameLog.setText("");
            }
        });
    }

    private void prepareGameLog() {
        gameLog = new JTextArea();
        scrollPanel = new JScrollPane(gameLog);
        gameLog.setEditable(false);
        gameLog.setLineWrap(true);
    }

    void recordLog(String text) {
        gameLog.append(text + "\n");
    }

    void clearRecordLog() {
        gameLog.setText("");
    }

    private void collectAllGameSetupFromUser() {
        ++round;
        recordLog("--- Round " + round + " ---");
    }
}

