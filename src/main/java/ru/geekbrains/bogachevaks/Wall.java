package ru.geekbrains.bogachevaks;

public class Wall extends  Let{


        public Wall(Builder builder){
            super(builder.length);
        }


    public static class Builder{
            private int length;

            public Builder length(int length){
                this.length = length;
                return this;
            }

            public Wall build(){
                return new Wall(this);
            }
        }
    }


