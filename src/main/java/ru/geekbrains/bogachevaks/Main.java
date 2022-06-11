package ru.geekbrains.bogachevaks;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        method1();
        method3();
        method2();
    }


    public static void  method1(){
        final int SIZE = 10_000_000;
        final int HALF = SIZE / 2;
        float[] arr = new float[SIZE];

        Arrays.fill(arr, 1.0f);

        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
           arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }

        System.out.println("method 1: " + (System.currentTimeMillis() - a));
    }

    public static void  method2(){
        final int SIZE = 10_000_000;
        final int THREAD_CNT = 4;
        float[] arr = new float[SIZE];
        Thread[] thread = new Thread[THREAD_CNT];
        float[][] arr2 = new float[THREAD_CNT][];

        Arrays.fill(arr, 1.0f);

        long a = System.currentTimeMillis();


        for (int i = 0; i < thread.length; i++) {
            int thread_num = i;
            thread[i] = new Thread( () -> {
                    int p_end = (((thread_num+1) * (arr.length/thread.length)) < arr.length)? (arr.length/thread.length) : (arr.length % thread.length) ;
                    //System.out.println("thread_num = " + thread_num + ",p_end = " + p_end + "thread.length = " + thread.length);
                    arr2[thread_num] = new float[p_end];
                    int p_start = thread_num * (arr.length/thread.length);
                    System.arraycopy(arr, p_start, arr2[thread_num], 0, p_end);
                    for (int j = 0; j < arr2[thread_num].length; j++) {
                        arr2[thread_num][j] = (float)(arr2[thread_num][j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) *
                                Math.cos(0.4f + j / 2));
                    }
                    System.arraycopy(arr2[thread_num], 0, arr, p_start, p_end);

                });
        }

        for (Thread t : thread  ) {
            t.start();

        }

        for (Thread t : thread  ) {
            try{
                t.join();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println("method 2: " + (System.currentTimeMillis() - a));
    }


    public static void  method3(){
        final int SIZE = 10_000_000;
        final int HALF = SIZE / 2;
        float[] arr = new float[SIZE];
        float[] arr2 = new float[HALF];
        float[] arr3 = new float[HALF];

        Arrays.fill(arr, 1.0f);

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr2, 0, HALF);
        System.arraycopy(arr, HALF, arr3, 0, HALF);

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int j = 0; j < arr2.length; j++) {
                    arr2[j] = (float) (arr2[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) *
                            Math.cos(0.4f + j / 2));
                }

            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int j = 0; j < arr3.length; j++) {
                    arr3[j] = (float) (arr3[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) *
                            Math.cos(0.4f + j / 2));
                }

            }
        };


        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        System.arraycopy(arr2, 0, arr, 0, HALF);
        System.arraycopy(arr3, 0, arr, HALF, HALF);

        System.out.println("method 3: " + (System.currentTimeMillis() - a));
    }
}

