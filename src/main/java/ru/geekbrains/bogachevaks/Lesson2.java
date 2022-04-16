package ru.geekbrains.bogachevaks;

public class Lesson2 {
    public static void main(String[] args) {
        int a = (int) (Math.random() * 20);
        int b = (int) (Math.random() * 20);
        int c = a - 10;
        //задание 1 - сумма лежит в пределах от 10 до 20 (включительно)
        System.out.println("Сумма чисел " + a + " и " + b + " лежит в пределах от 10 до 20 включительно: " + summ(a, b));

        //задание 2 - положительное ли число - текстовый формат
        System.out.println("Число " + c + ": " + isPositiveNum(c));

        //задание 3 - отрицательное число - boolean
        System.out.println("Число " + c + " отрицательное: " + isNegativeNum(c));

        //задание 4 - напечатать строку n раз
        System.out.println("Вывести строку \"Bilbo Baggins\" 5 раз:");
        printTextN("Bilbo Baggins", 5);
        System.out.println();

        //задание 5 - високосный ли год
        System.out.println("1600 год високосный: " + isLeapYear(1600));
        System.out.println("1700 год високосный: " + isLeapYear(1700));
        System.out.println("2024 год високосный: " + isLeapYear(2024));
        System.out.println("2025 год високосный: " + isLeapYear(2025));
    }

    public static boolean summ(int a, int b){
        return (a + b) >= 10 && (a + b) <= 20;
    }

    public static String isPositiveNum(int c){
        return (c >= 0) ? "положительное" : "отрицательное";
    }

    public static boolean isNegativeNum(int c){
        return !(c >= 0) ;
    }

    public static void printTextN(String str, int n){
        for(int i = 0; i < n; i++){
            System.out.println(str);
        }
    }

    public static boolean isLeapYear(int year){
        return ((year % 4 == 0 && year % 100 != 0 ) || (year % 400 == 0));
    }
}
