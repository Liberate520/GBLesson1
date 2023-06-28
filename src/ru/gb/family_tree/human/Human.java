package ru.gb.family_tree.human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private long id;
    private String name;
    private String surname;
    private LocalDate birthday;
    private Gender gender;
    private Human spouse;
    private List<Human> parents;
    private List<Human> children;

    public Human(String name, String surname, LocalDate birthday, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.gender = gender;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Human> getParents() {
        return parents;
    }

    public void setParents(List<Human> parents) {
        this.parents = parents;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Член семьи " +
                "№ = " + id +
                ", Имя -> " + name +
                ", Фамилия -> " + surname +
                ", дата рождения -> " + birthday);
        if (spouse != null) {
            sb.append(", супруг(-а) -> " + spouse.getName() + " " + spouse.getSurname());
        } else {
            sb.append(", не в браке");
        }
        if (parents.size() != 0) {
            sb.append(", родители ->");
            parents.stream().forEach(h -> sb.append(" член семьи № " + h.getId()));
        } else {
            sb.append(", нет данных о родителях");
        }
        if (children.size() != 0) {
            sb.append(", дети ->");
            children.stream().forEach(h -> sb.append(" член семьи № " + h.getId()));
        } else {
            sb.append(", нет данных о детях");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return getId() == human.getId();
    }
}
