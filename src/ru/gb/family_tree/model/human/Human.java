package ru.gb.family_tree.model.human;


import ru.gb.family_tree.model.tree.TreeLike;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human>, TreeLike<Human> {
    private long id;
    private String name;
    private String birthPlace;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(long id, String name, String birthPlace, Gender gender, LocalDate birthDate, LocalDate deathDate,
                 Human mother, Human father) {  //full
        this.id = id;
        this.name = name;
        this.birthPlace = birthPlace;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Human(long id, String name, String birthPlace, Gender gender, LocalDate birthDate) {  //alive?, unknown mom and dad
        this(id, name, birthPlace, gender, birthDate, null, null, null);
    }

    public Human(long id, String name, String birthPlace, Gender gender, LocalDate birthDate, Human par) {
        if (par.getGender() == Gender.Female) {
            this.id = id;
            this.name = name;
            this.birthPlace = birthPlace;
            this.gender = gender;
            this.birthDate = birthDate;
            this.deathDate = null;
            this.mother = par;
            this.father = null;
            children = new ArrayList<>();
        } else {
            this.id = id;
            this.name = name;
            this.birthPlace = birthPlace;
            this.gender = gender;
            this.birthDate = birthDate;
            this.deathDate = null;
            this.mother = null;
            this.father = par;
            children = new ArrayList<>();
        }
    }

    public Human(long id, String name, String birthPlace, Gender gender, LocalDate birthDate,
                 Human mother, Human father) {
        this(id, name, birthPlace, gender, birthDate, null, mother, father);
    }

    public long getId() {
        return id;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    private String getMotherInfo() {
        Human mother = getMother();
        if (mother != null) {
            return mother.name;
        } else
            return "Unknown";
    }

    private String getFatherInfo() {
        Human father = getFather();
        if (father != null) {
            return father.getName();
        } else
            return "Unknown";
    }

    public List<Human> getParents() {
        List<Human> parents = new ArrayList<>(2);
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }

        return parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    public boolean addParent(Human parent) {
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
        return true;
    }

    public String getChildrenInfo() {
        StringBuilder ch = new StringBuilder();
        if (children.size() != 0) {
            ch.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                ch.append(", ");
                ch.append(children.get(i).getName());
            }
        } else {
            ch.append("No children");
        }
        return ch.toString();
    }

    public String getAge() {
        if (deathDate != null) {
            return (Period.between(birthDate, deathDate)).getYears() + " (Dead)";
        } else {
            return (Period.between(birthDate, LocalDate.now())).getYears() + " (Alive)";
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name - ");
        sb.append(name);
        sb.append(", ID - ");
        sb.append(id);
        sb.append(", Gender - ");
        sb.append(gender);
        sb.append(", Birthday - ");
        sb.append(birthDate);
        sb.append(", Age - ");
        sb.append(getAge());
        sb.append(", Birth place - ");
        sb.append(getBirthPlace());
        sb.append(", Mother - ");
        sb.append(getMotherInfo());
        sb.append(", Father - ");
        sb.append(getFatherInfo());
        sb.append(", Children - ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.getName());
    }
}
