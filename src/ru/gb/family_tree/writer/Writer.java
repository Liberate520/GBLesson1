package ru.gb.family_tree.writer;

import ru.gb.family_tree.family_tree.FamilyTree;


import java.io.IOException;

import static ru.gb.family_tree.Main.testTree;
import static ru.gb.family_tree.writer.FileHandler.saveToFile;
import static ru.gb.family_tree.writer.FileHandler.loadFromFile;

public interface Writer {
    static void main(String[] args) {
        try {
            FamilyTree tree = testTree();
            saveToFile(tree, "FamilyTree.out");
            FamilyTree loadedTree = loadFromFile("FamilyTree.out");

            System.out.println(loadedTree);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
