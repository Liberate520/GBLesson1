package ru.gb.family_tree.model;

import java.util.Comparator;

public class HumanComparatorByName implements Comparator<ru.gb.family_tree.model.Human> {
    @Override
    public int compare(ru.gb.family_tree.model.Human o1, ru.gb.family_tree.model.Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
