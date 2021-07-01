package ru.geekbrains.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GameMap extends JPanel {

    private int human = 1;
    private int ai = 2;
    private int emptyField = 0;

    private Random random = new Random();

    private int mapSizeX = 7;
    private int mapSizeY = 6;

    private int cellWidth;
    private int cellHeight;

    private int winLength = 4;
    private int[][] map = new int[mapSizeX][mapSizeY];

    private boolean gameOver;
    private boolean isMapExist;

    private final int STATE_HUMAN_WIN = 1;
    private final int STATE_AI_WIN = 2;
    private final int STATE_DRAW = 0;

    private final String MSG_HUMAN_WIN = "Вы выиграли!";
    private final String MSG_AI_WIN = "Выиграл компьютер!";
    private final String MSG_DRAW = "Ничья!";

    private GameCollectFour gameCollectFour;

    public GameMap(GameCollectFour gameCollectFour) {
        this.gameCollectFour = gameCollectFour;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent mouseObject) {
                super.mouseReleased(mouseObject);
                update(mouseObject);
            }
        });
        isMapExist = false;
    }

    void startGame(int mapSizeX, int mapSizeY, int winLength) {
        this.mapSizeX = mapSizeX;
        this.mapSizeY = mapSizeY;
        this.winLength = winLength;
        this.gameOver = false;
        this.isMapExist = true;
        this.map = new int[mapSizeX][mapSizeY];
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        createMap(g);

        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {
                if (validTern(x, y)) {
                    continue;
                }

                if (map[x][y] == human) {
                    g.setColor(Color.GREEN);
                    g.fillOval(x * cellWidth + 10, y * cellHeight + 10, cellWidth - 20, cellHeight - 20);
                }

                if (map[x][y] == ai) {
                    g.setColor(Color.RED);
                    g.fillRect(x * cellWidth + 10, y * cellHeight + 10, cellWidth - 20, cellHeight - 20);
                }
            }
        }
        if (gameOver) {
            return;
        }
    }

    private boolean validTern(int x, int y) {
        if (map[x][y] != emptyField) {
            return false;
        }
        if (y == 0) {
            return true;
        }
        if (map[x][y - 1] == emptyField) {
            return false;
        }
        return true;
    }

    private void update(MouseEvent mouseObject) {
        if (gameOver) {
            return;
        }

        int cellX = mouseObject.getX() / cellWidth;
        int cellY = mouseObject.getY() / cellHeight;

        if (!validTern(cellX, cellY)) {
            return;
        }

        map[cellX][cellY] = human;
        gameCollectFour.recordLog("Ваш ход [" + (cellX + 1) + ":" + (cellY + 1) + "]");

        if (checkWin(human)) {
            setGameOver(STATE_HUMAN_WIN);
            return;
        }

        if (isFullMap()) {
            setGameOver(STATE_DRAW);
            return;
        }

        aiTurn();
        repaint();

        if (checkWin(ai)) {
            setGameOver(STATE_AI_WIN);
            return;
        }

        if (isFullMap()) {
            setGameOver(STATE_DRAW);
            return;
        }
    }

    private void setGameOver(int state) {
        repaint();
        this.gameOver = true;
        showGameOverMessage(state);
    }

    private void showGameOverMessage(int state) {
        switch (state) {
            case STATE_HUMAN_WIN:
                gameCollectFour.recordLog(MSG_HUMAN_WIN);
                JOptionPane.showMessageDialog(this, MSG_HUMAN_WIN);
                break;
            case STATE_AI_WIN:
                gameCollectFour.recordLog(MSG_AI_WIN);
                JOptionPane.showMessageDialog(this, MSG_AI_WIN);
                break;
            case STATE_DRAW:
                gameCollectFour.recordLog(MSG_DRAW);
                JOptionPane.showMessageDialog(this, MSG_DRAW);
                break;
            default:
                gameCollectFour.recordLog("Something wrong!");
                JOptionPane.showMessageDialog(this, "Something wrong! Incorrect game over state > " + state);
        }
    }

    private void createMap(Graphics g) {

        int width = getWidth();
        int height = getHeight();

        cellWidth = width / mapSizeX;
        cellHeight = height / mapSizeY;

        g.setColor(Color.WHITE);

        for (int i = 0; i <= mapSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }

        for (int i = 0; i <= mapSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, height);
        }

    }

    private void aiTurn() {
        if (turnAIWinCell()) {
            return;
        }
        if (turnHumanWinCell()) {
            return;
        }
        int x;
        int y;
        do {
            x = random.nextInt(mapSizeX);
            y = random.nextInt(mapSizeY);
        } while (!validTern(x, y));
        map[x][y] = ai;
        gameCollectFour.recordLog("Компьютер сходил [" + (x + 1) + ":" + (y + 1) + "]");
    }

    private boolean turnAIWinCell() {
        for (int i = 0; i < mapSizeX; i++) {
            for (int j = 0; j < mapSizeY; j++) {
                if (validTern(i,j)) {
                    map[i][j] = ai;
                    if (checkWin(ai)) {
                        return true;
                    }
                    map[i][j] = emptyField;
                }
            }
        }
        return false;
    }

    private boolean turnHumanWinCell() {
        for (int i = 0; i < mapSizeX; i++) {
            for (int j = 0; j < mapSizeY; j++) {
                if (validTern(i,j)) {
                    map[i][j] = human;
                    if (checkWin(human)) {
                        map[i][j] = ai;
                        return true;
                    }
                    map[i][j] = emptyField;
                }
            }
        }
        return false;
    }
    private boolean checkWin(int player) {

        for (int x=0; x<mapSizeX; x++){
            int count = 0;
            for (int y =0; y<mapSizeY; y++) {
                if (map[x][y] == player){ count++;}
                else { count= 0; }
                if (count >=4) return true;
            }
        }

        for (int y=0; y<mapSizeY; y++){
            int count = 0;
            for (int x =0; x <mapSizeX; x++) {
                if (map[x][y] == player){ count++;}
                else { count= 0; }
                if (count >=4) return true;
            }
        }

        int countD1 = 0;
        for (int d=0;d<=mapSizeX-mapSizeY;d++) {
            countD1 = 0;
            for (int i = 0; i < mapSizeY; i++) {
                if (map[i+d][i] == player) {
                    countD1++;
                } else {
                    countD1 = 0;
                }
                if (countD1 >= 4) return true;
            }
        }

        int countD2 = 0;
        for (int d=0;d<=mapSizeX-mapSizeY;d++) {
            countD2 = 0;
            for (int i = 0; i < mapSizeY; i++) {
                if (map[mapSizeY + d - i - 1][i] == player) {
                    countD2++;
                } else {
                    countD2 = 0;
                }
                if (countD2 >= 4) return true;
            }
        }

        return false;
    }
    private boolean isFullMap() {
        for (int i = 0; i < mapSizeY; i++) {
            for (int j = 0; j < mapSizeX; j++) {
                if (map[i][j] == emptyField) {
                    return false;
                }
            }
        }
        return true;
    }
    public void resetGame(){
        this.gameOver = false;
        this.isMapExist = true;
        this.map = new int[mapSizeX][mapSizeY];
        gameCollectFour.clearRecordLog();
        repaint();
    }
}



