package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.human.HumanBuilder;
import ru.gb.family_tree.model.storage.ConsoleSaverLoader;
import ru.gb.family_tree.model.tree.FamilyTree;

import java.time.LocalDate;

public class Service {
    private HumanBuilder hb;
    private FamilyTree<Human> tree;
    private ConsoleSaverLoader cSL;

    public Service() {
        tree = new FamilyTree();
        hb = new HumanBuilder();
        cSL = new ConsoleSaverLoader();
    }

    public void addHuman(String name, String birthPlace, Gender gender, LocalDate birthDate) {
        Human human = hb.build(name, birthPlace, gender, birthDate);
        tree.add(human);
    }

    public void addHuman(String name, String birthPlace, Gender gender, LocalDate birthDate, int parentID) {
        Human human = hb.build(name, birthPlace, gender, birthDate, parentID, tree);
        tree.add(human);
    }

    public void addHuman(String name, String birthPlace, Gender gender, LocalDate birthDate, int motherID, int fatherID) {
        Human human = hb.build(name, birthPlace, gender, birthDate, motherID, fatherID, tree);
        tree.add(human);
    }

    public void addChildToHuman(int parentID, int childID) {
        tree.addChildToTreeElement(parentID, childID);
    }

    public void setDeathDate(int humanID, LocalDate date) {
        tree.setDeathDate(humanID, date);
    }

    public boolean save(String path) {
        return cSL.save(tree, path);
    }

    public void load(String path) {
        tree = (FamilyTree) cSL.load(path);
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortByAge() {
        tree.sortByAge();
    }

    public String getHumansList() {
        return tree.toString();
    }
}
