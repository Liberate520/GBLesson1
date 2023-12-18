package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.human.HumanBuilder;
import ru.gb.family_tree.model.storage.FileHolder;
import ru.gb.family_tree.model.tree.FamilyTree;

import java.time.LocalDate;

public class Service {
    private HumanBuilder hb;
    private FamilyTree<Human> tree;

    public Service() {
        tree = new FamilyTree();
        hb = new HumanBuilder();
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
        for (Human parent : tree) {
            if (parent.getId() == parentID) {
                for (Human child : tree) {
                    if (child.getId() == childID) {
                        parent.addChild(child);
                        child.addParent(parent);
                    }
                }
            }

        }

    }
    public void setDeathDate(int humanID,LocalDate date){
        for(Human dead : tree){
            if (dead.getId() == humanID) {
                dead.setDeathDate(date);
            }
        }
    }

    public void save(String path) {
        FileHolder fh = new FileHolder();
        System.out.println("Family tree saved to '" + path + "'");
        if (!fh.save(tree, path)) {
            System.out.println("Something wrong on saving");
        }

    }

    public FamilyTree load(String path) {
        FileHolder fh = new FileHolder();
        tree = (FamilyTree) fh.load(path);
        return tree;
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortByAge() {
        tree.sortByAge();
    }

    public String getHumansList() {
        StringBuilder sb = new StringBuilder();
        sb.append("Humans in tree:\n");
        for (Human human : tree) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
}
