package ru.gb.family_tree.family_tree;

import java.util.List;

public interface FamilyTreeItem extends Comparable<FamilyTreeItem> {
    long getId();
    void setId(long id);
    String getName();
    java.time.LocalDate getBirthDate();
    List<? extends FamilyTreeItem> getParents();
    List<? extends FamilyTreeItem> getChildren();
    boolean addChild(FamilyTreeItem child);
    boolean addParent(FamilyTreeItem parent);
}
