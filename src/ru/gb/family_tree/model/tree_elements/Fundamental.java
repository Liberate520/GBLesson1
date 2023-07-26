package ru.gb.family_tree.model.tree_elements;

import java.time.LocalDate;
import java.util.List;

public interface Fundamental<E> {

    long getId();
    void setId(long id);
    String getName();
    E getSpouse();
    void setSpouse(E fundamental);
    List<E> getParents();
    void setParents(List<E> parents);
    List<E> getChildren();
    void setChildren(List<E> children);
    LocalDate getBirthday();
}
