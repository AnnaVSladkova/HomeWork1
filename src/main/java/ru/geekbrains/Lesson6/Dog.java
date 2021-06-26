package ru.geekbrains.Lesson6;

public class Dog extends Animal {
    public static int countDog = 0;

    Dog(String name, int maxRunDistance, int maxSwimDistance){
        super("Собака", name,maxRunDistance,maxSwimDistance);
        countDog++;
    }

}
