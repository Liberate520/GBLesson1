package ru.gb.family_tree.model.tree;

import java.util.Comparator;

public class FTComparatorByName<E extends TreeLike> implements Comparator<E> {
    @Override
    public int compare(E h1, E h2) {

        return h1.getName().compareTo(h2.getName());
    }
}

