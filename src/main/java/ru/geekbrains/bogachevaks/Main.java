package ru.geekbrains.bogachevaks;

public class Main {

    public static void main(String[] args) {
        int sum = 0;
        Array arr1 = new Array(3, 3);
        Array arr2 = new Array(4, 4);


        try {
            arr1.checkArr();
        }
        catch(MyArraySizeException e){
            System.out.println(e.toString());
            //e.printStackTrace();
        }
        arr1.printArr();

        try {
            sum = arr1.sumArr();
        }
        catch (MyArrayDataException e){
            System.out.println(e.toString());
            //e.printStackTrace();
        };
        
        System.out.println(sum);


        try {
            arr2.checkArr();
        }
        catch(MyArraySizeException e){
            System.out.println(e.toString());
            //e.printStackTrace();
        }
        arr2.printArr();

        try {
            sum = 0;
            sum = arr2.sumArr();
        }
        catch (MyArrayDataException e){
            System.out.println(e.toString());
            //e.printStackTrace();
        };

        System.out.println(sum);

    }
}
