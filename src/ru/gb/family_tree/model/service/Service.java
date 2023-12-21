package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.FamilyTree;
import ru.gb.family_tree.model.Person;
import ru.gb.family_tree.model.writer.FileHandler;
import ru.gb.family_tree.model.writer.Writable;
import ru.gb.family_tree.presenter.SavingType;

public class Service {

    private FamilyTree<Person> familyTree = new FamilyTree<>();

    private Writable writable;

    public void addFamilyTreeMember(Person person) {
        familyTree.addFamilyTreeMember(person);

    }

    public String getFamilyTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person : familyTree) {
            stringBuilder.append(person);
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public void addParent(Person person, Person child) {
        familyTree.addParent(person, child);
    }


    public void save(SavingType savingType) {
        switch (savingType) {
            case FILE -> {
                writable = new FileHandler();
            }
            default -> {
            }
        }
        writable.save(familyTree);
        writable = null;
    }

    public void load(SavingType savingType) {
        switch (savingType) {
            case FILE -> {
                writable = new FileHandler();
            }
            default -> {
            }
        }
        familyTree = (FamilyTree) writable.load();

        writable = null;
    }
}
