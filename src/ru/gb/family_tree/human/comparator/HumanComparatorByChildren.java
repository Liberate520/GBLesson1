package ru.gb.family_tree.human.comparator;

import ru.gb.family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByChildren implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o2.getChildren().size(), o1.getChildren().size());
    }
}
