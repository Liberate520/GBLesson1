package ru.gb.FamilyTree.Trees;

import java.util.Iterator;
import java.util.List;
import ru.gb.FamilyTree.Humans.Person;

public class PersonIterator implements Iterator<Person> {
    private List<Person> people;
    private int currentIndex = 0;

    public PersonIterator(List<Person> people) {
        this.people = people;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < people.size();
    }

    @Override
    public Person next() {
        return people.get(currentIndex++);
    }
}
