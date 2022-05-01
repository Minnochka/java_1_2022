package ru.geekbrains.bogachevaks;

public class Cat extends Animal{

    private final int maxRun = 200;
    private static int sum;

    public Cat(String name, int age, boolean male){
        super(name, age, male);
        sum++;
    }

    public static int getSum(){
        return sum;
    }

    @Override
    protected void run(int length) {
        if( length > maxRun){
            System.out.println(getName() + " не может пробежать " + length + " м.");
        }
        else{
            System.out.println(getName() + " пробежал(а) " + length + " м");
        }
    }

    @Override
    protected void swim(int length) {
        System.out.println(getName() + " не умеет плавать.");
    }
}
