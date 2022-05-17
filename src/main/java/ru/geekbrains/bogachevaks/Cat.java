package ru.geekbrains.bogachevaks;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite){
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }

    public int getAppetite() {
        return appetite;
    }

    public String getName(){
        return name;
    }

    public void eat(Plate p){
        System.out.println(name + " пытается съесть: " + appetite);
        satiety = p.decreaseFood(appetite);
        System.out.println(satiety?"Кот сыт":"Кот голоден");
    }


}
