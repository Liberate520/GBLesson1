package ru.gb.FamilyTree.Trees;
import java.util.ArrayList;
import java.util.List;

import ru.gb.FamilyTree.Humans.Person;

import java.util.Collections;
import java.util.Iterator;

public class FamilyTree implements Iterable<Person> {
    private List<Person> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator(people);
    }

    public void sortPeopleByName() {
        Collections.sort(people, (p1, p2) -> p1.getFullName().compareTo(p2.getFullName()));
    }

    public void sortPeopleByBirthDate() {
        Collections.sort(people, (p1, p2) -> p1.getBirthDate().compareTo(p2.getBirthDate()));
    }

    public void sortPeopleById() {
        Collections.sort(people, (p1, p2) -> p1.getId() - p2.getId());
    }

    public void addPerson(Person person) {
        people.add(person);
        updateRelationships();
    }

    public boolean isFamilyRelation(Person person, Person relative) {
        return person.getParents().contains(relative) ||
                relative.getParents().contains(person) ||
                person.getSiblings().contains(relative) ||
                relative.getSiblings().contains(person) ||
                person.getChildren().contains(relative) ||
                relative.getChildren().contains(person);
    }

    public void updateRelationships() {
        for (Person person : people) {
            List<Person> parents = getParentsOfPerson(person);
            for (Person parent : parents) {
                List<Person> parentChildren = parent.getChildren();
                if (parentChildren.size() > 1) {
                    for (Person child : parentChildren) {
                        if (child != person && !child.getSiblings().contains(person)) {
                            child.addSibling(person);
                            person.addSibling(child);
                        }
                    }
                }
                if (!parentChildren.contains(person)) {
                    parent.addChild(person);
                }
            }

            List<Person> siblings = getSiblingsOfPerson(person);
            for (Person sibling : siblings) {
                if (sibling != person && !sibling.getSiblings().contains(person)) {
                    sibling.addSibling(person);
                    person.addSibling(sibling);
                }

                List<Person> siblingParents = sibling.getParents();
                if (siblingParents.size() == 2 && !siblingParents.contains(person)) {
                    for (Person siblingParent : siblingParents) {
                        siblingParent.addChild(person);
                    }
                }
            }

            List<Person> children = person.getChildren();
            for (Person child : children) {
                if (!child.getParents().contains(person)) {
                    child.addParent(person);
                }

                List<Person> childSiblings = child.getSiblings();
                if (childSiblings.size() > 1) {
                    for (Person childSibling : childSiblings) {
                        if (childSibling != person && !childSibling.getSiblings().contains(person)) {
                            childSibling.addSibling(person);
                            person.addSibling(childSibling);
                        }
                    }
                }

                for (Person otherChild : children) {
                    if (otherChild != child && !child.getSiblings().contains(otherChild)) {
                        child.addSibling(otherChild);
                        otherChild.addSibling(child);
                    }
                }
            }
        }

        for (Person person : people) {
            List<Person> siblingsToRemove = new ArrayList<>();
            for (Person sibling : person.getSiblings()) {
                if (!person.getChildren().contains(sibling) && !person.getParents().contains(sibling)) {
                    siblingsToRemove.add(sibling);
                }
            }
            person.getSiblings().removeAll(siblingsToRemove);
        }
    }


    public Person findPersonById(int id) {
        for (Person person : people) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
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

    private List<Person> getSiblingsOfPerson(Person person) {
        List<Person> siblings = new ArrayList<>();
        for (Person p : people) {
            if (p != person && p.getParents().containsAll(person.getParents())) {
                siblings.add(p);
            }
        }
        return siblings;
    }
}
