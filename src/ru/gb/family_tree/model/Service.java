package ru.gb.family_tree.model;

import ru.gb.family_tree.family_tree.FamilyTree;

import java.time.LocalDate;
import java.util.List;

public class Service {
    private FamilyTree<ru.gb.family_tree.model.Human> familyTree;
    private HumanBuilder builder;

    public Service() {
        familyTree = new FamilyTree<>();
        builder = new HumanBuilder();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate, LocalDate deadDate, ru.gb.family_tree.model.Human mother, ru.gb.family_tree.model.Human father, List<ru.gb.family_tree.model.Human> children) {
        ru.gb.family_tree.model.Human human = builder
                .setName(name)
                .setGender(gender)
                .setBirthDate(birthDate)
                .setDeadDate(deadDate)
                .setMother(mother)
                .setFather(father)
                .build();

        if (children != null && !children.isEmpty()) {
            for (ru.gb.family_tree.model.Human child : children) {
                human.addChild(child);
            }
        }

        familyTree.addHuman(human);

    }
    public List<ru.gb.family_tree.model.Human> getByName(String name) {
        return familyTree.getByName(name);
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
        for(ru.gb.family_tree.model.Human human : familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}