package ru.gb.vending_machine.family_tree.utils;



import ru.gb.vending_machine.family_tree.model.FamilyTree;

import java.io.IOException;

public interface FamilyTreeFileManager<T> {
    void saveFamilyTree(FamilyTree<T> familyTree, String fileName) throws IOException;
    FamilyTree<T> loadFamilyTree(String fileName) throws IOException, ClassNotFoundException;
}
