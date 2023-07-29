package ru.gb.FamilyTree;

import java.time.LocalDate;
import java.util.List;
import ru.gb.FamilyTree.Trees.FamilyTree;
import ru.gb.FamilyTree.Humans.Person;
public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Person p1 = new Person("Иванов Иван", LocalDate.of(1950, 1, 1), null);
        Person p2 = new Person("Иванова Мария", LocalDate.of(1955, 5, 10), null);
        Person p3 = new Person("Иванов Владимир", LocalDate.of(1972, 9, 15), null);
        Person p4 = new Person("Сидорова Анна", LocalDate.of(1990, 9, 15), null);
        Person p5 = new Person("Иванов Егор", LocalDate.of(1990, 9, 15), null);

        familyTree.addPerson(p1);
        familyTree.addPerson(p2);
        familyTree.addPerson(p3);
        familyTree.addPerson(p4);
        familyTree.addPerson(p5);

        p1.addChild(p3);
        p2.addChild(p3);
        p3.addChild(p5);
        p4.addChild(p5);

        System.out.println("Дети Ивана: " + p1.getChildren());
        System.out.println("Дети Марии: " + p2.getChildren());
        System.out.println("Родители Владимира: " + familyTree.getParentsOfPerson(p3));
        System.out.println("Дети Владимира " + p3.getChildren());
        System.out.println("Дети Анны " + p4.getChildren());
        System.out.println("Родители Егора: " + familyTree.getParentsOfPerson(p5));

        FamilyTreeManager fileHandler = new FamilyTreeFileHandler();
        fileHandler.saveFamilyTree(familyTree, "family_tree.dat");
        FamilyTree loadedFamilyTree = fileHandler.loadFamilyTree("family_tree.dat");
        System.out.println("Загруженное семейное древо:");
        for (Person person : loadedFamilyTree.getAllPeople()) {
            System.out.println("Имя: " + person.getFullName());
            System.out.println("Дата рождения: " + person.getBirthDate());
            System.out.println("Дата смерти: " + person.getDeathDate());
            System.out.println("Родители: " + loadedFamilyTree.getParentsOfPerson(person));
            System.out.println("Дети: " + person.getChildren());
            System.out.println();
        }
    }
}