package ru.gb.family_tree;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Ivan", Gender.MALE);
        Person person2 = new Person("Masha", Gender.FEMALE);
        Person person3 = new Person("Petya");

        person2.setFather(person1);






    }


}
