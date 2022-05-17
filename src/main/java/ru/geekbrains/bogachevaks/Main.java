package ru.geekbrains.bogachevaks;

public class Main {
        public static void main(String[] args) {
            Cat cat1 = new Cat("Barsik", 5);
            Cat cat2 = new Cat("Kasandra", 10);
            Cat cat3 = new Cat("Mursik", 11);
            Cat cat4 = new Cat("Vasya", 5);
            Plate plate = new Plate(20, 50);
            Owner owner = new Owner("Boris", 10);
            plate.info();
            cat1.eat(plate);
            plate.info();
            cat2.eat(plate);
            plate.info();
            cat3.eat(plate);
            plate.info();
            cat4.eat(plate);
            plate.info();
            System.out.println("-------------------------");
            owner.putFood(plate);
            plate.info();
            cat3.eat(plate);
            plate.info();
            owner.putFood(plate);
            plate.info();
            cat3.eat(plate);
            plate.info();

        }
    }

