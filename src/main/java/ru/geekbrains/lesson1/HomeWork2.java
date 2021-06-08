package ru.geekbrains.lesson1;

public class HomeWork2 {
    public static void main(String[] args){
         System.out.println(within10and20(5, 15));
         isPositiveOrNegative(-8);
        System.out.println(isNegative(88));
        printWordTime("Hola!", 5);
        intercalaryYear(1861);
    }

    public static boolean within10and20(int a, int b) {
        return (a + b >= 10 && a + b <= 20);
    }

    public static void isPositiveOrNegative(int x) {
        if (x >=0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean isNegative(int a) {
        if (a <= 0) {
            return true;
        }
        return false;
    }

    public static void printWordTime(String word, int times) {
                for (int n = 0; n < times; n++) {
            System.out.println("String #" + n + ": " + word);
        }
    }

    public static boolean intercalaryYear(int year) {
        if (year % 4 ==0 && year % 100 != 0 && year % 400 ==0) {
            System.out.println(year + "Год високосный");
            return true;
        } else {
            System.out.println(year + " год не високосный");
            return false;
        }
    }
}
