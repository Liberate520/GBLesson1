package ru.gb.family_tree.model.tree.tree_service;

import ru.gb.family_tree.model.tree_elements.Fundamental;

import java.util.List;

public interface BaseFunctions <E extends Fundamental> {

    E addElement(E e);
    E getElement(long id);
    void addParents(long id, List<E> parents);
    List<E> getParents(long id);
    void addChildren(long id, List<E> children);
    List<E> getChildren(long id);
    void removeItem(long id);
    void addSpouse(long id1, long id2);
    void removeSpouse(long id);
}
