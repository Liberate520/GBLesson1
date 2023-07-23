package ru.gb.FamilyTree.Trees;
import java.util.ArrayList;
import java.util.List;
import ru.gb.FamilyTree.Humans.Person;

public class FamilyTree {
    private List<Person> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        people.add(person);
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
}
