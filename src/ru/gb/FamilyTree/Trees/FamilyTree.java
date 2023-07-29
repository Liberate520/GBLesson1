package ru.gb.FamilyTree.Trees;
import java.util.ArrayList;
import java.util.List;
import ru.gb.FamilyTree.Humans.Person;
import java.io.Serializable;

public class FamilyTree implements Serializable {
    private List<Person> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        people.add(person);
        List<Person> parents = getParentsOfPerson(person);
        for (Person parent : parents) {
            parent.addChild(person);
        }

        for (Person child : person.getChildren()) {
            child.addParent(person);
        }
    }

    public List<Person> getParentsOfPerson(Person person) {
        List<Person> parents = new ArrayList<>();
        for (Person p : people) {
            if (p.getChildren().contains(person)) {
                parents.add(p);
            }
        }
        return parents;
    }

    public List<Person> getAllPeople() {
        return new ArrayList<>(people);
    }
}
