package ru.gb.vending_machine;

import ru.gb.vending_machine.family_tree.*;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Person john = new Person("John", Gender.MALE, LocalDate.of(1970, 1, 1));
        Person jane = new Person("Jane", Gender.FEMALE, LocalDate.of(1975, 5, 5));
        Person paul = new Person("Paul", Gender.MALE, LocalDate.of(2000, 10, 10));
        Person anna = new Person("Anna", Gender.FEMALE, LocalDate.of(2005, 8, 20));

        john.addChild(paul);
        john.addChild(anna);
        jane.addChild(paul);
        jane.addChild(anna);

        familyTree.addPerson(john);
        familyTree.addPerson(jane);
        familyTree.addPerson(paul);
        familyTree.addPerson(anna);

        // Установим дату смерти для John
        john.setDeathDate(LocalDate.of(2020, 1, 1));

        System.out.println("Children of John:");
        for (Person child : familyTree.getChildren("John")) {
            System.out.println(child);
        }

        System.out.println("\nFamily Tree:");
        System.out.println(familyTree);

        System.out.println("\nAges:");
        System.out.println(john.getName() + " age: " + john.getAge());
        System.out.println(jane.getName() + " age: " + jane.getAge());
        System.out.println(paul.getName() + " age: " + paul.getAge());
        System.out.println(anna.getName() + " age: " + anna.getAge());

        FamilyTreeFileManager fileManager = new FamilyTreeFileManagerImpl();
        String fileName = "familyTree.ser";

        try {
            fileManager.saveFamilyTree(familyTree, fileName);
            System.out.println("\nFamily tree saved to " + fileName);

            FamilyTree loadedFamilyTree = fileManager.loadFamilyTree(fileName);
            System.out.println("\nLoaded Family Tree:");
            System.out.println(loadedFamilyTree);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}



