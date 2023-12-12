package ru.gb.family_tree;

import ru.gb.family_tree.person.Person;

import java.util.Iterator;
import java.util.List;

public class PersonIterator implements Iterator<Person> {
    private int index = 0;
    private List<Person> listPerson;

    public PersonIterator(List<Person> listPerson) {
        this.listPerson = listPerson;
    }

    @Override
    public boolean hasNext() {
        return index < listPerson.size();
    }

    @Override
    public Person next() {
        return listPerson.get(index++);
    }
}
