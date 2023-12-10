package ru.gb.family_tree.tree;

import java.util.Comparator;

public class FTComparatorByAge<E extends TreeLike> implements Comparator<E> {

    @Override
    public int compare(E o1,E o2) {

        return o2.getBirthDate().compareTo(o1.getBirthDate());
    }
}
