package ru.geekbrains.bogachevaks;

public class Treadmill  extends  Let{


    public Treadmill(Builder builder){
        super(builder.length);
    }

    public int getLength() {
        return length;
    }

    public static class Builder{
        private int length;

        public Builder length(int length){
            this.length = length;
            return this;
        }

        public Treadmill build(){
            return new Treadmill(this);
        }
    }
}
