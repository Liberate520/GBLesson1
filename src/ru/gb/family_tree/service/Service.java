package ru.gb.family_tree.service;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.HumanBuilder;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> familyTree;
    private HumanBuilder builder;

    public Service() {
        builder = new HumanBuilder();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate, LocalDate deadDate, Human mother, Human father, Human children) {
        Human human = builder
                .setName(name)
                .setGender(gender)
                .setBirthDate(birthDate)
                .setDeadDate(deadDate)
                .setMother(mother)
                .setFather(father)
                .build();
        familyTree.addHuman(human);

    }
    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByBirthDay() {
        familyTree.sortByBirthDay();
    }

    public String getHumanListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное древо: \n");
        for(Human human : familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}