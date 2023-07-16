package ru.gb.family_tree.tree_elements.comparator;

import ru.gb.family_tree.tree_elements.Fundamental;

import java.util.Comparator;

public class ElementsComparatorByName<E extends Fundamental> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
