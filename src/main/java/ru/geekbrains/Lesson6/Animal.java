package ru.geekbrains.Lesson6;

public abstract class Animal {
    static final int Swim_Fail=0;
    static final int Swim_Well=1;
    static final int Swim_Non=-1;

    private String type;
    protected String name;
    private int maxRunDistance;
    private int maxSwimDistance;

    public static int countAnimal = 0;
    Animal(String type,String name,int maxRunDistance, int maxSwimDistance){
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        ++countAnimal;
    }
    String getName() {return this.name;}
    String getType() {return this.type;}
    int getMaxRunDistance() {return this.maxRunDistance;}
    int getMaxSwimDistance() {return this.maxSwimDistance;}

    protected boolean run(int distance) {return distance <= maxRunDistance;}
    protected int swim(int distance) {return distance <=maxSwimDistance ? Swim_Well : Swim_Fail; }
}
