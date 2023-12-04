package ru.gb.family_tree;

import ru.gb.family_tree.service.Service;
import ru.gb.family_tree.tree.FamilyTree;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        Service.print(tree);
        FamilyTree testTree = Service.createTestTree();
        Service.print(testTree);
        Service.save(testTree);
        tree = Service.load();
        Service.print(tree);
        Service.sortByName(tree);
        System.out.println(tree);
        Service.sortByAge(tree);
        System.out.println(tree);
    }
}



