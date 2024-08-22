package ru.gb.family_tree.writer;

import ru.gb.family_tree.family_tree.FamilyTree;

import java.io.IOException;

import static ru.gb.family_tree.Main.testTree;

public interface Writer {
    static void main(String[] args) {
        FamilyTree tree = testTree();
        ru.gb.family_tree.writer.FileHandler fileHandler = new ru.gb.family_tree.writer.FileHandler();

        try {
            fileHandler.saveToFile(tree, "FamilyTree.out");
            FamilyTree loadedTree = fileHandler.loadFromFile("FamilyTree.out");
            System.out.println("Сохранённый файл: ");
            System.out.println(loadedTree);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
