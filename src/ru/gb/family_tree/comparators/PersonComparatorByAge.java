package ru.gb.family_tree.comparators;

import ru.gb.family_tree.model.Person;

import java.util.Comparator;

public class PersonComparatorByAge implements Comparator<Person> {
      @Override
    public int compare(Person o1, Person o2) {

        if (o1.getDateOfBirth().isBefore(o2.getDateOfBirth()) )
            return 1;
        else if (o1.getDateOfBirth().isAfter(o2.getDateOfBirth()))
            return -1;
        else
            return 0;
    }
}
