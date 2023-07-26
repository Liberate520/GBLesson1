package ru.gb.family_tree.model.tree_elements.comparator;

import ru.gb.family_tree.model.tree_elements.Fundamental;
import ru.gb.family_tree.model.tree_elements.Item;

import java.util.Comparator;

public class ElementsComparatorByName<E extends Fundamental<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
