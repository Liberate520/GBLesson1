package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.FamilyTree;
import ru.gb.family_tree.model.Gender;
import ru.gb.family_tree.model.Person;
import ru.gb.family_tree.model.writer.FileHandler;
import ru.gb.family_tree.model.writer.Writable;
import ru.gb.family_tree.model.writer.SavingType;

import java.time.LocalDate;

public class Service {

    private FamilyTree<Person> familyTree = new FamilyTree<>();

    private Writable writable;

    public void addFamilyTreeMember(String name, String sGender) {
        Gender gender;
        if (sGender.equals("M"))
            gender = Gender.MALE;
        else
            gender = Gender.FEMALE;
        Person person = new Person(name, gender);
        familyTree.addFamilyTreeMember(person);

    }

    public String getFamilyTreeInfo() {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (Person person : familyTree) {
//            stringBuilder.append(person);
//        }
//        return stringBuilder.toString();
        return familyTree.toString();

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

    void Personmake() {
        PersonBuilder personBuilder = new PersonBuilder();
        Person person = personBuilder
                .create()
                .buildName("Petya")
                .buildDateOfBirth(LocalDate.now())
                .buildDateOfDeath(LocalDate.now())
                .build();
    }
}
