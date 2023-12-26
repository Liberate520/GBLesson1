package ru.gb.family_tree.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
Выполняется принцип S (Единственной ответственности)
 **/
public class Person extends Member<Person> implements Serializable {

    private String name;
    private Gender gender;
    private LocalDate dateOfDeath;
    private LocalDate dateOfBirth;
    private Person father, mother;
    private final List<Person> children = new ArrayList<>();

    public List<Person> getChildren() {
        return children;
    }
    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(){
        this ("unknown");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Person getFather() {
        return father;
    }
    @Override
    public void setFather(Person father) {
        this.father = father;

    }

    public Person getMother() {
        return mother;
    }
    @Override
    public void setMother(Person mother) {
        this.mother = mother;

    }

    @Override
    public void addChild(Person child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return "Человек по имени " + name;
    }


}
