package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;

import java.awt.event.HierarchyBoundsAdapter;
import java.io.Serializable;
import java.util.*;

public class FamilyTree<E> implements Iterable<E extends FamilyTreeItem<E>>, Serializable {
    private long humansId;
    private List<E> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public boolean addHuman(E human) {
        if(human == null) {
            return false;
        }
        if(!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(E human) {
        for (E parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(E human) {
        for (E child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<E> getSiblings(int id) {
        E human = getById(id);
        if(human == null) {
            return  null;
        }
        List<E> res = new ArrayList<>();
        for (E parent : human.getParents()) {
            for (Human child : parent.getChildren()) {
                if(!child.equals(human)) {
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<E> getByName(String name) {
        List<E> res = new ArrayList<>();
        for (E human : humanList) {
            if(human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }

    private boolean checkId(long id) {
        return  id < humansId && id >= 0;
    }

    public E getById(long id) {
        for(HierarchyBoundsAdapter human : humanList) {
            if(human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public List<E> getHumanList() {
        return humanList;
    }

    public void setHumanList(List<E> humanList) {
        this.humanList = humanList;
    }

    public void sortByName() {
        Collections.sort(humanList, Comparator.comparing(E::getName));
    }

    public void sortByBirthDate() {
        Collections.sort(humanList, Comparator.comparing(E::getBirthDate).reversed());
    }

    @Override
    public String toString() {return getInfo();}

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Семейное дерево:\n");
        sb.append(humanList.size());
        sb.append(" позиции.\n");
        for (E human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public Iterator<E> iterator() {
        return humanList.iterator();
    }
}