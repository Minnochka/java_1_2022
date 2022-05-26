package ru.geekbrains.bogachevaks;

public class Cat implements Action{

    private final String name;
    private final int length_max;
    private final int height_max;

    public Cat(Builder builder) {
        this.name = builder.name;
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
            System.out.println("Кот " + name + " не может перепрыгрыгнуть " + height + " м.");
            return false;
        }
        else{
            System.out.println("Кот " + name + " перепрыгнул " + height + " м.");
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
            System.out.println("Кот " + name + " не может пробежать " + length + " м.");
            return false;
        }
        else{
            System.out.println("Кот " + name + " пробежал " + length + " м.");
            return true;
        }

    }


    public static class Builder{
        private String name;
        private int length_max;
        private int height_max;

        public Builder name(String name){
            this.name = name;
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

        public Cat build(){
            return new Cat(this);
        }
    }
}
