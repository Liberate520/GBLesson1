package ru.gb.family_tree.model;

import java.time.LocalDate;

public class HumanBuilder {
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deadDate;
    private ru.gb.family_tree.model.Human mother;
    private ru.gb.family_tree.model.Human father;

    public HumanBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public HumanBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public HumanBuilder setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public HumanBuilder setDeadDate(LocalDate deadDate) {
        this.deadDate = deadDate;
        return this;
    }

    public HumanBuilder setMother(ru.gb.family_tree.model.Human mother) {
        this.mother = mother;
        return this;
    }

    public HumanBuilder setFather(ru.gb.family_tree.model.Human father) {
        this.father = father;
        return this;
    }

    public ru.gb.family_tree.model.Human build() {
        ru.gb.family_tree.model.Human human = new ru.gb.family_tree.model.Human();
        human.setName(this.name);
        human.setGender(this.gender);
        human.setBirthDate(this.birthDate);
        human.setDeadDate(this.deadDate);
        human.setMother(this.mother);
        human.setFather(this.father);
        return human;
    }
}