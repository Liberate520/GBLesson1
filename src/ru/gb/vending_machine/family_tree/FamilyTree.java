package ru.gb.vending_machine.family_tree;

import java.util.HashMap;
import java.util.Map;

class FamilyTree {
    private Map<String, Person> people;
    private FileIOInterface fileIO;

    public FamilyTree() {
        this.people = new HashMap<>();
        this.fileIO = new FileIO();
    }

    public void addPerson(Person person) {
        people.put(person.getName(), person);
    }

    public Person findPersonByName(String name) {
        return people.get(name);
    }

    public Map<String, Person> getPeople() {
        return people;
    }

    public void saveToFile(String fileName) {
        fileIO.writeToFile(fileName, new ArrayList<>(people.values()));
    }

    public void loadFromFile(String fileName) {
        List<Person> personsFromFile = fileIO.readFromFile(fileName);
        if (personsFromFile != null) {
            for (Person person : personsFromFile) {
                addPerson(person);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person person : people.values()) {
            sb.append(person.toString()).append("\n");
        }
        return sb.toString();
    }
}