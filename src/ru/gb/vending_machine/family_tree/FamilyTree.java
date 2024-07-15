package ru.gb.vending_machine.family_tree;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamilyTree implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final Map<String, Person> people;

    public FamilyTree() {
        this.people = new HashMap<>();
    }

    public void addPerson(Person person) {
        people.put(person.getName(), person);
    }

    public Person getPerson(String name) {
        return people.get(name);
    }

    public List<Person> getChildren(String name) {
        Person person = people.get(name);
        if (person != null) {
            return person.getChildren();
        }
        return null;
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "people=" + people.values() +
                '}';
    }
}

