package ru.geekbrains.lesson1;

import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {

    public static char[][] map;
    public static int mapWidth;
    public static int mapHeight;
    public static int minSequence;

    public static char human = 'X';
    public static char pc = 'O';
    public static char empty = '_';

    public static Scanner pencil = new Scanner(System.in);
    public static Random random = new Random();

    public static void createMap() {
        mapWidth = 5;
        mapHeight = 5;
        minSequence = 4;
        map = new char[mapHeight][mapWidth];

        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                map[y][x] = empty;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i < mapWidth + 1; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int y = 0; y < mapHeight; y++) {
            System.out.print(y + 1 + "|");
            for (int x = 0; x < mapWidth; x++) {
                System.out.print(map[y][x] + "|");
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x;
        int y;

        do {
            System.out.print("Enter your coordinates: ");
            x = pencil.nextInt() - 1;
            y = pencil.nextInt() - 1;
        } while (!validCoordinates(y, x) || !emptyField(y, x));

        map[y][x] = human;
        System.out.println("Your move in [" + (x + 1) + ":" + (y + 1) + "]");
    }

    public static void pcTurn() {
        int x;
        int y;

        do {
            x = random.nextInt(mapWidth);
            y = random.nextInt(mapHeight);
        } while (!emptyField(y, x));

        map[y][x] = pc;
        System.out.println("PC move in [" + (x + 1) + ":" + (y + 1) + "]");
    }

    public static boolean validCoordinates(int y, int x) {
        return x >= 0 && x < mapWidth && y >= 0 && y < mapHeight;
    }

    public static boolean emptyField(int y, int x) {
        return map[y][x] == empty;
    }

    public static boolean fullMap() {
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWidth; x++) {
                if (map[y][x] == empty) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean win(char player) {

        for (int x=0; x<mapWidth; x++){
            int count = 0;
            for (int y =0; y<mapHeight; y++) {
                if (map[x][y] == player){ count++;}
                else { count= 0; }
                if (count ==minSequence) return true;
            }
        }

        for (int y=0; y<mapHeight; y++){
            int count = 0;
            for (int x =0; x <mapWidth; x++) {
                if (map[x][y] == player){ count++;}
                else { count= 0; }
                if (count ==minSequence) return true;
            }
        }

        int countD1 = 0;
        for (int i =0; i<mapHeight; i++) {
            if (map[i][i] == player){ countD1++;}
            else { countD1= 0; }
            if (countD1 ==minSequence) return true;
        }

        int countD2 = 0;
        for (int i =0; i<mapHeight; i++) {
            if (map[mapHeight -i-1][i] == player){ countD2++;}
            else { countD2= 0; }
            if (countD2 ==minSequence) return true;
        }


       return false;
    }

    public static void main(String[] args) {

        createMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (win(human)) {
                System.out.println("Human win!");
                break;
            }

            if (fullMap()) {
                System.out.println("Draw!");
                break;
            }

            pcTurn();
            printMap();

            if (win(pc)) {
                System.out.println("PC win!");
                break;
            }

            if (fullMap()) {
                System.out.println("Draw!");
                break;
            }
        }
        System.out.println("Game over!");
    }
}
