package ru.geekbrains.bogachevaks;

public class Human implements Action{

    private final String name;
    private final int age;
    private final int length_max;
    private final int height_max;

    private Human(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.length_max = builder.length_max;
        this.height_max = builder.height_max;
    }

    @Override
    public boolean jump(int height) {
        if (height < 0){
            System.out.println("Высота не может быть отрицательной");
            return  false;
        }
        else if (height > height_max){
            System.out.println("Человек " + name + " не может перепрыгруть " + height + " м.");
            return false;
        }
        else{
            System.out.println("Человек " + name + " перепрыгнул " + height + " м.");
            return  true;
        }

    }

    @Override
    public boolean run(int length) {
        if (length < 0){
            System.out.println("Длина не может быть отрицательной");
            return false;
        }
        else if (length > length_max){
            System.out.println("Человек " + name + " не может пробежать " + length + " м.");
            return false;
        }
        else{
            System.out.println("Человек " + name + " пробежал " + length + " м.");
            return true;
        }

    }

    public static class Builder{
        private String name;
        private int age;
        private int length_max;
        private int height_max;

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Builder length_max(int length_max){
            this.length_max = length_max;
            return this;
        }

        public Builder height_max(int height_max){
            this.height_max = height_max;
            return this;
        }

        public Human build(){
            return new Human(this);
        }
    }


}
