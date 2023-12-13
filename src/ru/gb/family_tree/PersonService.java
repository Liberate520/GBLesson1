package ru.gb.family_tree;

import ru.gb.family_tree.comparators.PersonComparatorByAge;
import ru.gb.family_tree.comparators.PersonComparatorByName;
import ru.gb.family_tree.model.Person;
import ru.gb.family_tree.writer.Writable;

public class PersonService {
    private final FamilyTree<Person> familyTree = new FamilyTree<>();
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

    public void addParent(Person person, Person child) {
        familyTree.addParent(person, child);
    }


    public void save(Writable writable) {
        familyTree.save(writable);
    }

    public void load(Writable writable) {
        familyTree.load(writable);
    }

    public void sortByName() {
        familyTree.sortByName(new PersonComparatorByName());
    }
    public void sortByAge() {
        familyTree.sortByAge(new PersonComparatorByAge());
    }
}
