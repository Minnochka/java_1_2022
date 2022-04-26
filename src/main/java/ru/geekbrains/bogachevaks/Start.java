package ru.geekbrains.bogachevaks;

public class Start {
    public static void main(String[] args) {
        Employee[] empArray = new Employee[5]; // Вначале объявляем массив объектов
        empArray[0] = new Employee("иванов иван иванович", "врач", "ivanovii@mailbox.com", "892312312", 60000, 30);
        empArray[1] = new Employee("романова мария викторовна", "медсестра", "romanovamv@mailbox.com", "+79036764455", 15000, 19);
        empArray[2] = new Employee("золотарев георгий михайлович", "программист", "zolotarevgm@mailbox.com", "89161232323", 300000, 43);
        empArray[3] = new Employee("янковская ольга дмитриевна", "бухгалтер", "yankovskayaod@mailbox", "89995872543", 80000, 48);
        empArray[4] = new Employee("максимов павел романович", "охранник", "maksimovpr@mailbox.com", "+79067872656", 30000, 32);

        for(Employee e : empArray){
            if (e.getAge() > 40){
                e.printInfo();
            }
        }
    }
}
