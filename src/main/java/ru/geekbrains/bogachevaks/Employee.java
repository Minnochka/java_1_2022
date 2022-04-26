package ru.geekbrains.bogachevaks;

import java.util.regex.Pattern;

public class Employee {
    private String FIO = "";
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String FIO, String position, String email, String phone, int salary, int age){
        if (FIO.length() > 3) {
            String[] emp = FIO.split(" ");

            for (String s : emp) {
                this.FIO += s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase() + " ";
            }
            this.FIO = this.FIO.trim();
        }
        else {
            this.FIO = "-";
        }

        if (position.length() > 3){
            this.position = position;
        }
        else{
            this.position = "-";
        }

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +  //part before @
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email != null && pat.matcher(email).matches()){
            this.email = email;
        }
        else{
            this.email = "-";
        }

        String phoneRegex = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";
        pat = Pattern.compile(phoneRegex);
        if (phone != null && pat.matcher(phone).matches()){
            this.phone = phone;
        }
        else{
            this.phone = "-";
        }

        if (salary > 0) {
            this.salary = salary;
        }
        else{
            this.salary = 0;
        }

        if (age >= 18 ){
            this.age = age;
        }
        else{
            this.age = 0;
        }
    }

    public float getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getFIO() {
        return FIO;
    }

    public String getPhone() {
        return phone;
    }

    public String getPosition() {
        return position;
    }

    public void printInfo(){
        System.out.println("-----------------------");
        System.out.println("ФИО: " + FIO);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary + " руб.");
        System.out.println("Возраст: " + age);
    }
}
