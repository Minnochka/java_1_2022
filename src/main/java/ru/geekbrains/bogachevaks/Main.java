package ru.geekbrains.bogachevaks;

import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String[] arr = new String[] {"мама", "папа", "дом", "кот", "собака","мышь","мама","окно","кот",
                "мама", "кот","дом", "мама", "кот"};
        HashMap<String, Integer> map = new HashMap<>();

        long startTime, estimatedTime;

        for(String s : arr){
            if (map.containsKey(s)){
                map.put(s, map.get(s) + 1);
            }
            else{
                map.put(s, 1);
            }
        }

        System.out.println("Задание 1:");
        System.out.println(Arrays.toString(arr));

        for(var pair : map.entrySet()){
            String key = pair.getKey();
            Integer value = pair.getValue();
            System.out.println(key + ": " + value);
        }

        System.out.println("Задание 2.1:");
        startTime = System.nanoTime();
        DirectoryNew directoryNew = new DirectoryNew();

        directoryNew.add("Вавилова Анна Михайловна", 79165763434L);
        directoryNew.add("Семенов Константин Игоревич", 79165763434L);
        directoryNew.add("Тюрин Максим Андреевич", 79034587887L);
        directoryNew.add("Тюрин Максим Андреевич", 89056764321L);
        directoryNew.add("Тюрин Максим андреевич", 15654321341L);
        directoryNew.add("Вавилова Анна Михайловна", 79165763434L);
        directoryNew.print();
        directoryNew.get("Тюрин Максим андреевич");
        directoryNew.get("Тюрин Максим сергеевич");

        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Время выполнения в мс: " + estimatedTime);

        System.out.println("Задание 2:");
        startTime = System.nanoTime();
        Directory directory = new Directory();

        directory.add("Вавилова Анна Михайловна", 79165763434L);
        directory.add("Семенов Константин Игоревич", 79165763434L);
        directory.add("Тюрин Максим Андреевич", 79034587887L);
        directory.add("Тюрин Максим Андреевич", 89056764321L);
        directory.add("Тюрин Максим андреевич", 15654321341L);
        directory.add("Вавилова Анна Михайловна", 79165763434L);
        directory.print();
        directory.get("Тюрин Максим андреевич");
        directory.get("Тюрин Максим сергеевич");

        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Время выполнения в мс: " + estimatedTime);

    }
}
