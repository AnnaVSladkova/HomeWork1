package ru.geekbrains.Lesson6;

public class HomeWork6 {
    public static void main(String [] args){
        String tempOkEvent = "получилось";
        String tempLossEvent ="не получилось";
        String eventName;
        String eventResult;

        Cat cat1= new Cat("Рыжик",155,1);
        Cat cat2= new Cat("Пират",200,1);
        Cat cat3= new Cat("Матвей",200,2);
        Dog dog1= new Dog("Дэни", 300, 9);
        Dog dog2= new Dog("Полкан", 500, 10);
        Dog dog3= new Dog("Тобик", 450, 8);

        Animal[] animals= { cat1, cat2, cat3, dog1, dog2, dog3};
        int runDistance =180;
        int swimDistance = 7;

        for (int i=0;  i<animals.length; i++) {
            String nameString = animals[i].getType()+" "+ animals[i].getName()+" может ";

            eventName="пробежать на "+animals[i].getMaxRunDistance()+ " м. Пытается пробежать на ";
            eventResult= animals[i].run(runDistance)? tempOkEvent : tempLossEvent;
            result(nameString, eventName, runDistance,eventResult);

            int swimResult = animals[i].swim(swimDistance);
            eventName = "проплыть на " + animals[i].getMaxSwimDistance()+ " м.Пытается проплыть на ";
            eventResult = (swimResult == Animal.Swim_Well) ? tempOkEvent : tempLossEvent;

            if(swimResult == Animal.Swim_Non){
                eventResult = "не получилось, не умеет плавать";
            result(nameString, eventName,swimDistance,eventResult);
            } else {
                eventResult ="получилось проплыть";
                result(nameString, eventName,swimDistance,eventResult);
            }

        }
        System.out.println("Всего животных "+ Animal.countAnimal + ", котов "+ Cat.countCat + ", собак "+Dog.countDog);
      }
      private static void result(String nameAnimal, String event, int eventDistance, String eventResult) {
        System.out.println( nameAnimal + event+ eventDistance + " м и "+ eventResult);
    }

}
