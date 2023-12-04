package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.Human;

import java.util.Comparator;

public class FTComparatorByName implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {

        return h1.getName().compareTo(h2.getName());
    }
}

