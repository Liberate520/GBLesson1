package ru.gb.FamilyTree.Humans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Person implements Serializable {
    private static int lastAssignedId = 0;
    private int id;
    private String fullName;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private List<Person> children;
    private List<Person> parents;
    private List<Person> siblings;

    public Person(String fullName, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        this.id = ++lastAssignedId;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.siblings = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public List<Person> getParents() {
        return parents;
    }

    public void addParent(Person parent) {
        parents.add(parent);
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public void addSibling(Person sibling) {
        siblings.add(sibling);
    }

    public String getRelationToWithGender(Person other) {
        if (this.parents.contains(other)) {
            if (other.getGender() == Gender.MALE) {
                return "отец";
            } else {
                return "мать";
            }
        } else if (hasCommonChildren(this, other)) {
            if (other.getGender() == Gender.MALE) {
                return "муж";
            } else {
                return "жена";
            }
        } else if (this.children.contains(other)) {
            if (other.getGender() == Gender.MALE) {
                return "сын";
            } else {
                return "дочь";
            }
        } else if (this.siblings.contains(other)) {
            if (other.getGender() == Gender.MALE) {
                return "брат";
            } else {
                return "сестра";
            }
        } else {
            return "родственник";
        }
    }

    private boolean hasCommonChildren(Person person1, Person person2) {
        for (Person child : person1.getChildren()) {
            if (person2.getChildren().contains(child)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
