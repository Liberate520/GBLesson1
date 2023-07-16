package ru.gb.family_tree;

import ru.gb.family_tree.handler.FileHandler;
import ru.gb.family_tree.tree_elements.Gender;
import ru.gb.family_tree.tree_elements.Human;
import ru.gb.family_tree.tree.FamilyTree;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        FamilyTree<Human> familyTree = new FamilyTree<>();
        Human parent1 = familyTree.addHuman(new Human("Sergei", "Ivanov", LocalDate.parse("20.11.1961", formatter), Gender.Male));
        Human parent2 = familyTree.addHuman(new Human("Natalia", "Ivanova", LocalDate.parse("09.03.1961", formatter), Gender.Female));

        familyTree.addSpouse(parent1.getId(), parent2.getId());

        Human human = familyTree.addHuman(new Human("Alex", "Ivanov", LocalDate.parse("12.06.1986", formatter), Gender.Male));

        familyTree.addChildren(parent1.getId(), Arrays.asList(human));
        familyTree.addChildren(parent2.getId(), Arrays.asList(human));
        familyTree.addParents(human.getId(), Arrays.asList(parent1, parent2));

        Human wife = familyTree.addHuman(new Human("Sveta", "Petrova", LocalDate.parse("07.05.1990", formatter), Gender.Female));

        familyTree.addSpouse(human.getId(), wife.getId());

        Human child1 = familyTree.addHuman(new Human("Olga", "Ivanova", LocalDate.parse("14.09.2021", formatter), Gender.Female));
        Human child2 = familyTree.addHuman(new Human("Petr", "Ivanov", LocalDate.parse("22.12.2019", formatter), Gender.Male));

        familyTree.addChildren(human.getId(), Arrays.asList(child1, child2));
        familyTree.addChildren(wife.getId(), Arrays.asList(child1, child2));
        familyTree.addParents(child1.getId(), Arrays.asList(human, wife));
        familyTree.addParents(child2.getId(), Arrays.asList(human, wife));

        System.out.println("Такое получилось дерево: ");
        familyTree.getElementList().stream().forEach(System.out::println);

        FileHandler fileHandler = new FileHandler("data.txt");
        fileHandler.save(familyTree);

        System.out.println("Проверка сохранения:");
        FamilyTree treeAfterSave = fileHandler.read();
        treeAfterSave.forEach(System.out::println);
        System.out.println("Проверка сортировки по дням рождения:");
        treeAfterSave.getHumanWithSortByBirthday().forEach(System.out::println);
        System.out.println("Проверка сортировки по количеству детей:");
        treeAfterSave.getHumanWithSortByChildren().forEach(System.out::println);
        System.out.println("Проверка сортировки по имени:");
        treeAfterSave.getHumanWithSortByName().forEach(System.out::println);
    }
}
