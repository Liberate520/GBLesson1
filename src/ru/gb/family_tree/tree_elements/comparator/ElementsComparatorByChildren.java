package ru.gb.family_tree.tree_elements.comparator;

import ru.gb.family_tree.tree_elements.Fundamental;

import java.util.Comparator;

public class ElementsComparatorByChildren<E extends Fundamental> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o2.getChildren().size(), o1.getChildren().size());
    }
}
