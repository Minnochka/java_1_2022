package ru.geekbrains.bogachevaks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;

public class Directory {

    private HashMap<String, LinkedList> FIOList;


    public Directory(){
        LinkedList<Long> phoneList = new LinkedList<>();
        phoneList.add(79036558171L);
        phoneList.add(79132315223L);
        FIOList = new HashMap<>();
        FIOList.put("Иванова Мария Дмитриевна", phoneList);
    }

    public  boolean add(String FIO, Long phone){
        if (FIOList.containsKey(FIO.toLowerCase(Locale.ROOT).trim())){
            LinkedList<Long> phoneList = FIOList.get(FIO.toLowerCase(Locale.ROOT).trim());
            if(phoneList.contains(phone)){
                System.out.println("Человек с именем " + FIO + " и телефоном " + phone + " уже записан в справочник.");
                return false;
            }
            else{
                phoneList.add(phone);
            }
        }
        else{
            LinkedList<Long> phoneList = new LinkedList<>();
            phoneList.add(phone);
            FIOList.put(FIO.toLowerCase(Locale.ROOT).trim(),phoneList);
        }
        return  true;
    }

    public void get(String FIO){
        if (FIOList.containsKey(FIO.toLowerCase(Locale.ROOT).trim())) {
            LinkedList<Long> phoneList = FIOList.get(FIO.toLowerCase(Locale.ROOT).trim());
            System.out.println(phoneList);
        }
        else {
            System.out.println("Для человека " + FIO + " телефонов не найдено.");
        }
    }

    public void print(){
        for(var pair : FIOList.entrySet()){
            String FIO = pair.getKey();
            LinkedList<Long> phones = pair.getValue();
            System.out.println(FIO + ": " + phones);
        }
    }
}
