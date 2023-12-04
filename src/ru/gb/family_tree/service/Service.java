package ru.gb.family_tree.service;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.storage.FileHodler;
import ru.gb.family_tree.tree.FamilyTree;

import java.time.LocalDate;

public class Service {
    public static FamilyTree createTestTree() {
        FamilyTree tree = new FamilyTree();

        Human me = new Human("Denis", "Krasnodar", Gender.Male, LocalDate.of(1987, 07, 07));

        Human wife = new Human("Jane", "Murmansk", Gender.Female, LocalDate.of(1991, 05, 05));

        Human daughter = new Human("Alice", "Sochi", Gender.Female, LocalDate.of(2016, 12, 12), wife, me);
        tree.add(me);
        tree.add(wife);
        tree.add(daughter);
        Human mom = new Human("Nataly", "Ural", Gender.Female, LocalDate.of(1965, 02, 02));
        tree.add(mom);
        mom.addChild(me);
        return tree;
    }

    public static void save(FamilyTree tree) {
        String path = "src/ru/gb/family_tree/storage/NewTree.out";
        FileHodler fh = new FileHodler();
        System.out.println("Family tree saved to '" + path + "'");
        if(!fh.save(tree, path)){
            System.out.println("Something wrong on saving");
        }

    }

    public static FamilyTree load() {
        String path = "src/ru/gb/family_tree/storage/NewTree.out";
        FileHodler fh = new FileHodler();
        return (FamilyTree) fh.load(path);
    }

    public static void sortByName(FamilyTree tree) {
        tree.sortByName();
    }

    public static void sortByAge(FamilyTree tree) {
        tree.sortByAge();
    }

    public static void print(FamilyTree tree) {
        if(tree.isEmpty() ){
            System.out.println("Tree is empty");
        }
        else{
            System.out.println(tree);
        }
    }
}
