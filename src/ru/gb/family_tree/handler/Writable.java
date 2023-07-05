package ru.gb.family_tree.handler;

import ru.gb.family_tree.tree.FamilyTree;

import java.util.List;

public interface Writable {
    void save(FamilyTree familyTree);
    FamilyTree read();
}
