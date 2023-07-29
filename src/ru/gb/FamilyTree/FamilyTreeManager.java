package ru.gb.FamilyTree;

import ru.gb.FamilyTree.Trees.FamilyTree;

public interface FamilyTreeManager {
    void saveFamilyTree(FamilyTree familyTree, String filename);
    FamilyTree loadFamilyTree(String filename);
}
