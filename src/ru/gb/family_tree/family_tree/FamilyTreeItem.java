package ru.gb.family_tree.family_tree;

import java.util.List;

public interface FamilyTreeItem<T> extends Comparable<T> {
    int getAge();
    String getName();
    void setId(long id);
    List<T> getParents();
    void addChild(T child);
    List<T> getChildren();
    void addParent(T parent);
    long getId();
}
