package ru.gb.family_tree.model.tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeLike<E> extends Serializable {
    String getName();
    String getAge();
    long getId();
    E getFather();
    E getMother();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    List<E> getParents();
    List<E> getChildren();
    boolean addParent(E treeElement);
    boolean addChild(E treeElement);

    void setDeathDate(LocalDate date);
}
