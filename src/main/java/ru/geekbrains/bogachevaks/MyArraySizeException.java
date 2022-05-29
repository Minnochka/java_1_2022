package ru.geekbrains.bogachevaks;

public class MyArraySizeException extends Exception {

    public MyArraySizeException(){
        super("Массив имеет размерность, отличную от 4*4.");
    }
}
