package ru.geekbrains.bogachevaks;

public class Dog extends Animal{

    private final int maxRun = 150;
    private final int maxSwim = 50;
    private static int sum;

    public Dog (String name, int age, boolean male){
        super(name, age, male);
        sum++;
    }

    public static int getSum(){
        return sum;
    }

    @Override
    public void run(int length){
        if (length > maxRun){
            System.out.println(getName() + " не может пробежать " + length + " м.");
        }
        else{
            System.out.println(getName() + " пробежал(а) " + length + " м.");
        }
    }

    @Override
    public void swim(int length){
        if (length > maxSwim){
            System.out.println(getName() + " не может проплыть " + length + " м.");
        }
        else{
            System.out.println(getName() + " проплыл(а) " + length + " м.");
        }
    }
}
