package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.Human;

import java.util.Comparator;

public class FTComparatorByAge implements Comparator<Human> {

    @Override
    public int compare(Human o1,Human o2) {
        return o2.getBirthDate().compareTo(o1.getBirthDate());
    }
}
