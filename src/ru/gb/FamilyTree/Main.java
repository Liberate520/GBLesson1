package ru.gb.FamilyTree;

import java.time.LocalDate;
import java.util.List;

import ru.gb.FamilyTree.Humans.Gender;
import ru.gb.FamilyTree.Trees.FamilyTree;
import ru.gb.FamilyTree.Humans.Person;
public class Main {
    public static void main(String[] args) {
        FamilyTree FamilyTree = new FamilyTree();

        Person p1 = new Person("Иванов Иван", LocalDate.of(1950, 1, 1), null, Gender.MALE);
        Person p2 = new Person("Иванова Мария", LocalDate.of(1955, 5, 10), null, Gender.FEMALE);
        Person p3 = new Person("Иванов Владимир", LocalDate.of(1972, 9, 15), null, Gender.MALE);
        Person p4 = new Person("Сидорова Анна", LocalDate.of(1990, 9, 15), null, Gender.FEMALE);
        Person p5 = new Person("Иванов Егор", LocalDate.of(1990, 9, 15), null, Gender.MALE);
        Person p6 = new Person("Иванов Ольга", LocalDate.of(1974, 3, 8), null, Gender.FEMALE);

        FamilyTree.addPerson(p1);
        FamilyTree.addPerson(p2);
        FamilyTree.addPerson(p3);
        FamilyTree.addPerson(p4);
        FamilyTree.addPerson(p5);
        FamilyTree.addPerson(p6);

        p1.addChild(p3);
        p2.addChild(p3);
        p3.addChild(p5);
        p4.addChild(p5);
        p6.addParent(p1);
        p6.addParent(p2);
        FamilyTree.updateRelationships();

//        int targetPersonId = 3; // Пример: выводим информацию о человеке с id = 3
//        Person targetPerson = FamilyTree.findPersonById(targetPersonId);
//        if (targetPerson != null) {
//            System.out.println("Информация о человеке с id " + targetPersonId + ":");
//            System.out.println("Имя: " + targetPerson.getFullName());
//            System.out.println("Дата рождения: " + targetPerson.getBirthDate());
//            System.out.println("Дата смерти: " + targetPerson.getDeathDate());
//            System.out.println("Пол: " + targetPerson.getGender());
//            System.out.println("Родственники:");
//            for (Person relative : FamilyTree.getAllPeople()) {
//                if (relative != targetPerson && FamilyTree.isFamilyRelation(targetPerson, relative)) {
//                    System.out.println(relative.getFullName() + " - " + targetPerson.getRelationToWithGender(relative));
//                }
//            }
//        } else {
//            System.out.println("Человек с id " + targetPersonId + " не найден.");
//        }

        System.out.println("Семейное древо:");
        for (Person person : FamilyTree.getAllPeople()) {
            System.out.println("Имя: " + person.getFullName());
            System.out.println("Дата рождения: " + person.getBirthDate());
            System.out.println("Дата смерти: " + person.getDeathDate());
            System.out.println("Пол: " + person.getGender());
            System.out.println("Родители: " + person.getParents());
            System.out.println("Дети: " + person.getChildren());
            System.out.println("Братья и сестры: " + person.getSiblings());
            System.out.println();
        }

//        FamilyTreeManager fileHandler = new FamilyTreeFileHandler();
//        fileHandler.saveFamilyTree((FamilyTree) FamilyTree, "family_tree.dat");
//        FamilyTree loadedFamilyTree = fileHandler.loadFamilyTree("family_tree.dat");
//        System.out.println("Загруженное семейное древо:");
//        for (Person person : loadedFamilyTree.getAllPeople()) {
//            System.out.println("Имя: " + person.getFullName());
//            System.out.println("Дата рождения: " + person.getBirthDate());
//            System.out.println("Дата смерти: " + person.getDeathDate());
//            System.out.println("Родители: " + loadedFamilyTree.getParentsOfPerson(person));
//            System.out.println("Дети: " + person.getChildren());
//            System.out.println();
//        }
        FamilyTree.sortPeopleByName();
        for (Person person : FamilyTree) {
            System.out.println(person.getFullName());
        }

        FamilyTree.sortPeopleByBirthDate();
        for (Person person : FamilyTree) {
            System.out.println(person.getFullName() + " - " + person.getBirthDate());
        }

        FamilyTree.sortPeopleById();
        for (Person person : FamilyTree) {
            System.out.println(person.getFullName() + " - ID: " + person.getId());
        }
    }
}