package ru.geekbrains.bogachevaks;

public class Owner {
    private String name;
    private int food;

    public Owner( String name, int food){
        this.name = name;
        this.food = food;
    }

    public void putFood(Plate p){
        System.out.println(name + " пытается положить еду: " + food);
        System.out.println(p.increaseFood(food)?" Миска пополнена":"В миске нет места");
    }
}
