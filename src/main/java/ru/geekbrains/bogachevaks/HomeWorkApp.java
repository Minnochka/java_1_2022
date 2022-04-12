package ru.geekbrains.bogachevaks;

public class HomeWorkApp {
    public static void main(String[] args) {
        System.out.println("Hello!");
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign(){
        int a = 5, b = -11;
        System.out.println("Введены числа " + a + " и " + b + ".");
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        }
        else{
            System.out.println("Сумма отрицательная");
        }
    }

    public static void  printColor(){
        int value = 114;
        if (value <= 0){
            System.out.println("Красный");
        }
        else if (value >= 100){
            System.out.println("Зеленый");
        }
        else{
            System.out.println("Желтый");
        }
    }

    public static void compareNumbers(){
        int a = 5, b= 10;
        if (a >= b){
            System.out.println("a >= b");
        }
        else{
            System.out.println("a < b");
        }
    }
}
