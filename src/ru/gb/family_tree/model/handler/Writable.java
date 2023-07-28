package ru.gb.family_tree.model.handler;

import ru.gb.family_tree.model.tree.FamilyTree;

public interface Writable {
    void save(FamilyTree familyTree);
    FamilyTree read();
}
