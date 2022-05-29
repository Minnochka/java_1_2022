package ru.geekbrains.bogachevaks;

import java.util.Arrays;
import java.util.Random;

public class Array {

    private String[][] arr;
    private static char[] sAlphabet = "0123456789AB".toCharArray();
    private static Random sRandom = new Random();


    public Array(int s, int c){
        if (s < 0 ){
            s = 2;
        }
        if (c < 0){
            c = 2;
        }
        this.arr = new String[s][c];

        for(int i = 0; i < this.arr.length; i++){
            for (int j = 0; j < this.arr[0].length; j++){
                this.arr[i][j] = String.valueOf(sAlphabet[sRandom.nextInt(sAlphabet.length)]);
            }
        }
    }

    public void checkArr() throws MyArraySizeException {
        if (arr.length != 4 || arr[0].length != 4){
                throw new MyArraySizeException();
        }
    }

    public int sumArr() throws MyArrayDataException{
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                try{
                    sum += Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e){
                    throw new MyArrayDataException(i, j);
                }

            }
        }
        return sum;
    }

    /*public int sumArr2() {
        int sum = 0;
        try{
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    sum += Integer.parseInt(arr[i][j]);
                }
            }
        }
        catch (NumberFormatException e){
        }
        return sum;
    }*/

    public void printArr(){
        System.out.println(Arrays.deepToString(arr));
    }
}
