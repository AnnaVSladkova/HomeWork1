package ru.geekbrains.Lesson6;

public class Cat extends Animal {
    public static int countCat =0;

    Cat(String name, int maxRunDistance, int maxSwimDistance){
         super("Кот", name,maxRunDistance, maxSwimDistance);
         countCat++;
    }
    @Override
    public int swim(int distace){
        return Swim_Non;
    }

}
