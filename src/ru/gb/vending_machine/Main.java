package ru.gb.vending_machine;

import ru.gb.vending_machine.family_tree.FamilyTree;
import ru.gb.vending_machine.family_tree.Person;


public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Person john = new Person("John", "Male", "01-01-1970");
        Person jane = new Person("Jane", "Female", "05-05-1975");
        Person paul = new Person("Paul", "Male", "10-10-2000");
        Person anna = new Person("Anna", "Female", "20-08-2005");

        john.addChild(paul);
        john.addChild(anna);
        jane.addChild(paul);
        jane.addChild(anna);

        familyTree.addPerson(john);
        familyTree.addPerson(jane);
        familyTree.addPerson(paul);
        familyTree.addPerson(anna);

        System.out.println("Children of John:");
        for (Person child : familyTree.getChildren("John")) {
            System.out.println(child);
        }

        System.out.println("\nFamily Tree:");
        System.out.println(familyTree);
    }
}

