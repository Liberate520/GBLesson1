package ru.gb.family_tree.comparators;

import ru.gb.family_tree.model.Member;
import ru.gb.family_tree.model.Person;

import java.util.Comparator;

public class ComparatorByAge <T extends Member>implements Comparator<T> {
      @Override
    public int compare(T o1, T o2) {

        if (o1.getDateOfBirth().isBefore(o2.getDateOfBirth()) )
            return 1;
        else if (o1.getDateOfBirth().isAfter(o2.getDateOfBirth()))
            return -1;
        else
            return 0;
    }
}
