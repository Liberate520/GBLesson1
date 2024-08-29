package ru.gb.family_tree.model;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.writer.FileHandler;

import java.time.LocalDate;
import java.util.List;

public class Service {
    private HumanBuilder builder;
    private FamilyTree<Human> familyTree;
    private FileHandler fileHandler;

    public Service() {
        fileHandler = new FileHandler("src/ru/gb/family_tree/writer/family_tree.txt");
        familyTree = (FamilyTree<Human>) fileHandler.readFile();
        if (familyTree == null) {
            familyTree = new FamilyTree<>();
        }
        builder = new HumanBuilder();
    }
    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }

    public void setFamilyTree(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate, LocalDate deadDate, Human mother, Human father, List<Human> children) {
        Human human = builder
                .setName(name)
                .setGender(gender)
                .setBirthDate(birthDate)
                .setDeadDate(deadDate)
                .setMother(mother)
                .setFather(father)
                .build();

        if (children != null && !children.isEmpty()) {
            for (Human child : children) {
                human.addChild(child);
            }
        }

        familyTree.addHuman(human);

    }

    public List<Human> getByName(String name) {
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
        for(Human human : familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getHumanListInfo();
    }

    public boolean saveFamilyTree(String fileName) {
        fileHandler = new FileHandler(fileName);
        return fileHandler.saveFile(familyTree);
    }

    public FamilyTree<Human> loadFamilyTree(String fileName) {
        fileHandler = new FileHandler(fileName);
        return (FamilyTree<Human>) fileHandler.readFile();
    }
}
