package ru.gb.family_tree.service;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Human;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Service {
    private FamilyTree familyTree;

    public Service(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void sortByName() {
        List<Human> humans = familyTree.getHumanList();
        Collections.sort(humans, Comparator.comparing(Human::getName));
        familyTree.setHumanList(humans);
    }

    public void sortByBirthDate() {
        List<Human> humans = familyTree.getHumanList();
        Collections.sort(humans, Comparator.comparing(Human::getBirthDate).reversed());
        familyTree.setHumanList(humans);
    }
}
