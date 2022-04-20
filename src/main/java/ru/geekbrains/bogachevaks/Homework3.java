package ru.geekbrains.bogachevaks;

import java.util.Arrays;

public class Homework3 {
    public static void main(String[] args) {
        System.out.println("Задание 1 -------------------------");
        execTask1(10);
        System.out.println("Задание 2 -------------------------");
        execTask2(100);
        System.out.println("Задание 3 -------------------------");
        execTask3();
        System.out.println("Задание 4 -------------------------");
        execTask4(7);
        System.out.println("Задание 5 -------------------------");
        int[] res = execTask5(10, 83);
        System.out.println("Результат:\n" + Arrays.toString(res));
        System.out.println("Задание 6 -------------------------");
        execTask6(10);
        System.out.println("Задание 7 -------------------------");
        System.out.println(execTask7(new int[]{1, 1, 1, 2, 1}));
        System.out.println(execTask7(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
        System.out.println(execTask7(new int[]{3, 8, 1, 5}));
        System.out.println("Задание 8 -------------------------");
        //execTask8(new int[]{1,2,3,4,5,6,7,8,9,10}, 4);
        execTask8v2(new int[]{1,2,3,4,5,6,7,8,9,10}, -2);
    }

    public static void execTask1(int n){
        int[] arrNum = new int[n];

        for (int i = 0; i < arrNum.length; i++) {
            arrNum[i] = (int) (Math.random() * 2);
        }
        System.out.println("Исходный массив:\n" + Arrays.toString(arrNum));


        for (int i = 0; i < arrNum.length; i++){
            arrNum[i] = (arrNum[i] + 1) % 2;
        }
        System.out.println("Результат:\n" + Arrays.toString(arrNum));
    }

    public static void execTask2(int n) {
        int[] arrNum = new int[n];

        for (int i = 0; i < arrNum.length; i++){
            arrNum[i] = i + 1;
        }

        System.out.println("Результат:\n" + Arrays.toString(arrNum));
    }

    public static void execTask3(){
        int[] arrNum = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив:\n" + Arrays.toString(arrNum));

        for(int i = 0; i < arrNum.length; i++){
            if (arrNum[i] < 6){
                arrNum[i] *= 2;
            }
        }

        System.out.println("Результат:\n" + Arrays.toString(arrNum));
    }

    public static void execTask4(int n){
        int[][] arrNum = new int[n][n];

        for(int i = 0; i < arrNum.length; i++){
            for( int j = 0; j < arrNum[i].length; j++){
                if (i == j || i + j == arrNum.length - 1){
                    arrNum[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < arrNum.length; i++) {
            for (int j = 0; j < arrNum[i].length; j++) {
                System.out.printf("%3d", arrNum[i][j]);
            }
            System.out.println();
        }
    }

    public static int[] execTask5(int len, int initialValue) {
        int[] arrNum = new int[len];
        Arrays.fill(arrNum, initialValue);
        return arrNum;
    }

    public static void execTask6(int n){
        int[] arrNum = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arrNum.length; i++) {
            arrNum[i] = (int) (Math.random() * 100);
        }

        System.out.println("Исходный массив:\n" + Arrays.toString(arrNum));

        for (int i = 0; i < arrNum.length; i++){
            if(arrNum[i] < min){
                min = arrNum[i];
            }
            if(arrNum[i] > max){
                max = arrNum[i];
            }
        }
        System.out.println("минимальное число: " + min);
        System.out.println("максимальное число: " + max);
    }

    public static boolean execTask7(int[] arr){
        int sum = 0;
        int sum1 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        for (int i = 0; i < arr.length; i++){
            sum1 += arr[i];
            sum -= arr[i];
            if (sum == sum1){
                //System.out.println("сумма элементов с 1 по " + (i + 1) + " равна сумме элементов с " + (i + 2) + " по " + arr.length);
                return true;
            }
        }
        return false;

    }

    /*public static void execTask8(int[] arr, int n){
        int t;
        for (int i = 0; i < arr.length - n; i++) {
            t= arr[i];
            arr[i] = arr[i + n];
            arr[i + n] = t;
        }

        System.out.println("Массив:\n" + Arrays.toString(arr));

        for( int j = 0; j < arr.length % n ; j++){
            for(int i = arr.length - n; i < arr.length; i++) {

                if (i + j == arr.length - n){
                    t = arr[i];
                    arr[i] = arr[arr.length - 1];
                    arr[arr.length - 1] = t;
                }
                else if (i + j == arr.length - 1){
                    t = arr[i + j];
                    arr[i + j] = arr[arr.length - n];
                    arr[arr.length - n] = t;
                }
                else {
                    t = arr[i + j];
                    arr[i + j] = arr[i + 1 + j];
                    arr[i + 1 + j] = t;
                }
                System.out.println("Массив " + i + ":\n" + Arrays.toString(arr));

            }
        }
        System.out.println("Массив:\n" + Arrays.toString(arr));
        System.out.println(arr.length % n);
    }*/

    public static void execTask8v2(int[] arr, int n){
        int t;

        System.out.println("Исходный массив:\n" + Arrays.toString(arr) + "\nсдвиг:" + n);

        if (n > 0){
            n = arr.length - n;
        }
        else {
            n = Math.abs(n);
        }
        if (n != 0) {
            for (int i = n; i < arr.length; i++) {
                for (int j = 0; j < n; j++) {
                    t = arr[i - j];
                    arr[i - j] = arr[i - 1 - j];
                    arr[i - 1 - j] = t;
                    //System.out.println("Массив " + i + ":\n" + Arrays.toString(arr));
                }
            }
        }

        System.out.println("Массив:\n" + Arrays.toString(arr));


    }
}

