package ru.gb.family_tree.tree_elements.comparator;

import ru.gb.family_tree.tree_elements.Fundamental;

import java.util.Comparator;

public class ElementsComparatorByBirthday<E extends Fundamental> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        if (o1.getBirthday().isAfter(o2.getBirthday())) {
            return 1;
        } else if (o1.getBirthday().isBefore(o2.getBirthday())) {
            return -1;
        } else {
            return 0;
        }
    }
}
