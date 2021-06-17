package ru.geekbrains.lesson1;

public class HomeWork5 {
}
public class Person {

    private String name;
    private String position;
    private int age;
    private int phoneNamber;
    private  String email;
    private String salary;



    public Person(String name, String position, int age, int phoneNamber, String email, String salary) {
        this.name = name;
        this.position = position;
        this.age = age;
        this.phoneNamber = phoneNamber;
        this.email = email;
        this.salary = salary;
    }

    public Person(String name) {
        this.name = name;
        System.out.println("This is overload constructor");
    }

    private Person[][] newPerson;
    Person[]persArray = newPerson[5];

    persArray[0]= newPerson(name = "Василий Гришин", age = 45);
    persArray[1]= newPerson(name = "Екатерина Симонова", age = 31);
    persArray[2]= newPerson(name = "Елена Зюзькина", age = 39);
    persArray[3]= newPerson(name = "Константин Котов", age = 25);
    persArray[4]= newPerson(name = "Юлия Шишкина", age = 55);
    for (int i=0, i<5, i++){
        if (persArray [i].age >40);
        System.out.println();
    }

    //Getter
    public String getName() {
        return name;
    }

    //Setter
    public void setName(String name) {
        this.name = name;
    }

}
