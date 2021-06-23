package ru.geekbrains.lesson1;

public class Staff {
    public static void main(String [] args){
        Person person1=new Person("Василий Гришин", "администратор",45, 7667,"grishinV@example.com", 60000);
        Person person2=new Person("Екатерина Симонова", "парикмахер",31, 7931,"esimonova1@example.com", 40000);
        Person person3=new Person("Елена Зюзькина", "мастер маникюра",39, 7852,"zuza@example.com", 30000);
        Person person4=new Person("Константин Котов", "парикмахер",25, 7667,"kostyankot@example.com", 40000);
        Person person5=new Person("Юлия Шубина", "уборщица",55, 7267,"shubina66@example.com", 20000);

        person1.name = "Василий Гришин";
        person1.position = "администратор";
        person1.age = 45;
        person1.phoneNamber = 7667;
        person1.email = "grishinV@example.com";
        person1.salary = 60000;

        person2.name = "Екатерина Симонова";
        person2.position = "парикмахер";
        person2.age = 31;
        person2.phoneNamber = 7931;
        person2.email = "esimonova1@example.com";
        person2.salary = 40000;

        person3.name = "Елена Зюзькина";
        person3.position = "мастер маникюра";
        person3.age = 39;
        person3.phoneNamber = 7852;
        person3.email = "zuza@example.com";
        person3.salary = 30000;

        person4.name = "Константин Котов";
        person4.position = "парикмахер";
        person4.age = 25;
        person4.phoneNamber = 7667;
        person4.email = "kostyankot@example.com";
        person4.salary = 40000;

        person4.name = "Юлия Шубина";
        person4.position = "парикмахер";
        person4.age = 55;
        person4.phoneNamber = 7267;
        person4.email = "уборщица";
        person4.salary = 20000;

        System.out.println("Сотрудник: "+ person1.getName() + person1.getPosition() + person1.getAge() + person1.getPhoneNamber() + Person1.getEmail() + person1.getSalary());
        System.out.println("Сотрудник: "+ person2.getName() + person2.getPosition() + person2.getAge() + person2.getPhoneNamber() + person2.getEmail() + person2.getSalary());
        System.out.println("Сотрудник: "+ person3.getName() + person3.getPosition() + person3.getAge() + person3.getPhoneNamber() + person3.getEmail() + person3.getSalary());
        System.out.println("Сотрудник: "+ person4.getName() + person4.getPosition() + person4.getAge() + person4.getPhoneNamber() + person4.getEmail() + person4.getSalary());
        System.out.println("Сотрудник: "+ person5.getName() + person5.getPosition() + person5.getAge() + person5.getPhoneNamber() + person5.getEmail() + person5.getSalary());






    }
}
