package ru.gb.vending_machine.family_tree;

import java.io.IOException;

public interface FamilyTreeFileManager {
    void saveFamilyTree(FamilyTree familyTree, String fileName) throws IOException;
    FamilyTree loadFamilyTree(String fileName) throws IOException, ClassNotFoundException;
}

