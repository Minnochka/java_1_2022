package ru.geekbrains.bogachevaks;

public class MyArrayDataException extends Exception{

    public MyArrayDataException(int i, int j){
        super("Значение в ячейке [" + i + "][" + j + "] не является числом.");
    }
}
