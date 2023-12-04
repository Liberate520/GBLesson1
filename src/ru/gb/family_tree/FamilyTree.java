package ru.gb.family_tree;

import ru.gb.family_tree.writer.FileHandler;
import ru.gb.family_tree.writer.Writable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {

    private final List<Person> familyTree = new ArrayList<Person>();


    public void addFamilyTreeMember(Person person) {
        familyTree.add(person);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person : familyTree) {
            stringBuilder.append(person);
        }
        return stringBuilder.toString();
    }

    public void addParent(Person person, Person child) {
        if (person.getGender().equals(Gender.MALE)) {
            child.setFather(person);
        } else child.setMother(person);
        person.addChild(child);
    }


    public void save(Writable writable) {
        writable.save(this);
    }

    public void load(Writable writable) {
        writable.load(this);
    }
}
