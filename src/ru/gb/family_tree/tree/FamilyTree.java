package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FamilyTree implements Serializable {
    private long humansID;
    private List<Human> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humansID++);


            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }

    private void addToParents(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    public boolean isEmpty() {
        if (humanList.isEmpty()) {
            return true;
        }
        return false;
    }

    public void sortByName() {
        System.out.println("Family tree sorted by Name");
        Collections.sort(humanList, new FTComparatorByName());
    }

    public void sortByAge() {
        System.out.println("Family tree sorted by Age");
        Collections.sort(humanList, new FTComparatorByAge());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Family Tree:\n");
        for (Human human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
}
