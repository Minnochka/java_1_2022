package ru.geekbrains.bogachevaks;

public class Robot implements Action{

    private final String model;
    private final int length_max;
    private final int height_max;

    public Robot(Builder builder){
        this.model = builder.model;
        this.length_max = builder.length_max;
        this.height_max = builder.height_max;
    }

    @Override
    public boolean jump(int height) {
        if (height < 0){
            System.out.println("Высота не может быть отрицательной");
            return false;
        }
        else if (height > height_max){
            System.out.println("Робот " + model + " не может перепрыгруть " + height + " м.");
            return false;
        }
        else{
            System.out.println("Робот " + model + " перепрыгнул " + height + " м.");
            return true;
        }

    }

    @Override
    public boolean run(int length) {
        if (length < 0){
            System.out.println("Длина не может быть отрицательной");
            return false;
        }
        else if (length > length_max){
            System.out.println("Робот " + model + " не может пробежать " + length + " м.");
            return false;
        }
        else{
            System.out.println("Робот " + model + " пробежал " + length + " м.");
            return true;
        }

    }

    public static class Builder{
        private String model;
        private int length_max;
        private int height_max;

        public Builder model(String model){
            this.model = model;
            return this;
        }

        public Robot.Builder length_max(int length_max){
            this.length_max = length_max;
            return this;
        }

        public Robot.Builder height_max(int height_max){
            this.height_max = height_max;
            return this;
        }

        public Robot build(){
            return new Robot(this);
        }
    }
}
