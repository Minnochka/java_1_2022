package ru.geekbrains.bogachevaks;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Пэджи", 2, false);
        Dog dog1 = new Dog("Сэм", 5, true);
        Cat cat2 = new Cat("Касандра", 1, false);
        Dog dog2 = new Dog("Рекс", 3, true);
        Dog dog3 = new Dog("Буч", 8, true);

        cat1.run(100);
        cat2.run(300);
        cat1.swim(100);
        cat2.swim(2);

        dog1.run(30);
        dog2.run(3000);
        dog1.swim(400);
        dog2.swim(1);

        System.out.println("Кол-во собак: " + Dog.getSum());
        System.out.println("Кол-во кошек: " + Cat.getSum());
        System.out.println("Кол-во животных: " + Animal.getSum());
    }
}
