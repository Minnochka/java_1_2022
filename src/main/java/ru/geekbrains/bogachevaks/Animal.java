package ru.geekbrains.bogachevaks;

public abstract class Animal {

    private String name;
    private int age;
    private boolean male;
    private static int sum;

    public Animal(String name, int age, boolean male) {
        this.name = name;
        this.age = age;
        this.male = male;
        sum++;
    }

    public static int getSum(){
        return sum;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getMale(){
        return male ? "мужской" : "женский";
    }

    protected abstract void run(int length);

    protected abstract void swim(int length);

    public static void printMessage() {
        System.out.println("base static method");
    }
}
