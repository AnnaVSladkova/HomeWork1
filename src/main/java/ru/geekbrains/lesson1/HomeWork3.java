package ru.geekbrains.lesson1;

import java.util.Random;

public class HomeWork3 {

    public static void main(String[] args) {
        System.out.println("Задание 1");
        someMassiv(args);
        System.out.println("Задание 2");
        massiv100(args);
        System.out.println("Задание 3");
        int12(args);
        System.out.println("Задание 4");
        square(args);
        System.out.println("Задание 5");
        metodLen(5,2);
        System.out.println("Задание 6");
        minMax(args);
    }

    public static void someMassiv(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int j = 0; j < 10; j++) {
            arr[j] = random.nextInt(2);
            System.out.print(arr[j] + " | ");
        }
        System.out.println("");
        for (int j = 0; j < 10; j++) {
            if (arr[j] == 0) {
                arr[j] = 1;
            } else {
                arr[j] = 0;
            }
            System.out.print(arr[j] + " | ");
        }
        System.out.println();
    }

    public static void massiv100(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
            System.out.print("arr[" + i + "] = " + arr[i] + " | ");
        }
        System.out.println();
    }

    public static void int12(String[] args) {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                System.out.print(arr[i] * 2 + " | ");
            } else {
                System.out.print(arr[i] + " | ");
            }

        }
        System.out.println();
    }

    public static void square(String[] args) {
        int[][] arr = new int[6][6];
        for (int i = 0; i < 6; i++) {
            arr[i][i] = 1;
            arr[i][5 - i] = 1;
        }
          for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (arr[i][j] == 1) {
                    System.out.print("1");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    public static int[] metodLen(int len, int initialValue) {
        int[] arr = new int[len];
        for (int a = 0; a < len; a++) {
            arr[a] = initialValue;
            System.out.println(arr[a]+ " ");

        }
        return arr;
    }

    public static void minMax(String [] args){
        int []arr = new int[15];
        Random random= new Random();
        for (int x=0;x<15; x++){
            arr[x]= random.nextInt(30);
            System.out.print(arr[x] + " | ");
        }
        int max=0;
        for (int x=0;x<15; x++){
            if (arr[x]> max){
                max=arr[x];
            }
        }
        int min=max;
        for (int x=0;x<15; x++){
            if (arr[x]<min){
                min=arr[x];
                }
        }
        System.out.println();
        System.out.println("min =" +min+ " max=" +max);
    }
}
