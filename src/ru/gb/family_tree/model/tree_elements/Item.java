package ru.gb.family_tree.model.tree_elements;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Item implements Fundamental<Item>, Serializable {
    private long id;
    private String name;
    private String surname;
    private LocalDate birthday;
    private Gender gender;
    private Item spouse;
    private List<Item> parents;
    private List<Item> children;

    public Item(String name, String surname, LocalDate birthday, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.gender = gender;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" ");
        sb.append(surname);
        return sb.toString();
    }

    @Override
    public List<Item> getParents() {
        return parents;
    }

    @Override
    public void setParents(List<Item> parents) {
        this.parents = parents;
    }

    @Override
    public void setChildren(List<Item> children) {
        this.children = children;
    }

    @Override
    public List<Item> getChildren() {
        return children;
    }

    @Override
    public Item getSpouse() {
        return spouse;
    }

    @Override
    public void setSpouse(Item spouse) {
        this.spouse = spouse;
    }

    @Override
    public LocalDate getBirthday() {
        return birthday;
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
            sb.append(", супруг(-а) -> " + spouse.getName());
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
        if (!(o instanceof Item)) return false;
        Item human = (Item) o;
        return getId() == human.getId();
    }
}
