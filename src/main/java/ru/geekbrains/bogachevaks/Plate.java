package ru.geekbrains.bogachevaks;

public class Plate {
    private int food;
    private int volume;

    public Plate(int food, int volume){
        if (food > 0){
            this.food = food;
            this.volume = volume;
        }
        else{
            this.food = 0;
            this.volume = 10;
        }
    }

    public boolean increaseFood(int n){
        if (volume - food < n){
            System.out.println("Недостаточно места");
            return false;
        }
        else{
            this.food += n;
            return true;
        }
    }

    public boolean decreaseFood(int n){
        if (food < n){
            System.out.println("Недостаточно пищи");
            return false;
        }
        else{
            this.food -= n;
            return true;
        }
    }

    public void info(){
        System.out.println("В тарелке:" + food);
    }
}
