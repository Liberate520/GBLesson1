package ru.gb.family_tree.comparators;

import ru.gb.family_tree.model.Member;
import ru.gb.family_tree.model.Person;

import java.util.Comparator;

public class ComparatorByName <T extends Member>implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
