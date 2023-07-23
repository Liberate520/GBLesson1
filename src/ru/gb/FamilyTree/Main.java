package ru.gb.FamilyTree;

import java.util.List;
import ru.gb.FamilyTree.Trees.FamilyTree;
import ru.gb.FamilyTree.Humans.Person;
public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Person p1 = new Person("Иванов Иван", "1950-01-01");
        Person p2 = new Person("Иванова Мария", "1955-05-10");
        Person p3 = new Person("Иванов Владимир", "1972-09-15");
        Person p4 = new Person("Сидорова Анна", "1990-09-15");
        Person p5 = new Person("Иванов Егор", "1990-09-15");

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
        System.out.println("Дети Анны" + p4.getChildren());
        System.out.println("Родители Егора: " + familyTree.getParentsOfPerson(p5));
    }
}
