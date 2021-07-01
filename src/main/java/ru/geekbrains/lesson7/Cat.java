package ru.geekbrains.lesson7;

public class Cats {

    private String name;
    private int appetite;
    public Cats(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }
    public void eat(Plate p) {
        p.decreaseFood(appetite);
    }
}

