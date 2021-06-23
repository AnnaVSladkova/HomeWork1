package ru.geekbrains.lesson1;

public class HomeWorkApp {


    public static void main(String[] args) {
        printTreeWords();
        checkSumSign();
        printColor();
        compareNambers();

    }

    public static void printTreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");


    }

    public static void checkSumSign() {
        int a = 6;
        int b = -7;
        int x = a + b;
        if (x < 0) {
            System.out.println("Сумма отрицательная");
        } else {
            System.out.println("Сумма положительная");
        }
    }

    public static void printColor() {
        int value = 10;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value >= 1 && value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зелёный");
        }
    }

    public static void compareNambers(){
        int a=15;
        int b=-6;
        if (a >= b){
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
            }

    }
}