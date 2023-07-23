package ru.gb.FamilyTree.Humans;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String fullName;
    private String birthDate;
    private List<Person> children;

    public Person(String fullName, String birthDate) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.children = new ArrayList<>();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
