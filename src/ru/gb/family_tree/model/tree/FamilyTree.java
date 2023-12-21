package ru.gb.family_tree.model.tree;

import ru.gb.family_tree.model.human.HumanIterator;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeLike<E>> implements Serializable, Iterable<E> {
    private long memberID;
    private List<E> membersList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> membersList) {
        this.membersList = membersList;
    }

    public void add(E treeElement) {
        membersList.add(treeElement);
        addToParents(treeElement);
        addToChildren(treeElement);
    }

    private void addToChildren(E treeElement) {
        for (E child : treeElement.getChildren()) {
            child.addParent(treeElement);
        }
    }

    private void addToParents(E treeElement) {
        for (E parent : treeElement.getParents()) {
            parent.addChild(treeElement);
        }
    }

    public E getParent(int parentID) {

        for (E parent : membersList) {
            if (parent.getId() == parentID)
                return parent;
        }
        return null;
    }

    public void setDeathDate(int elementID, LocalDate date) {
        for (E dead : membersList) {
            if (dead.getId() == elementID) {
                dead.setDeathDate(date);
            }
        }
    }
    public void addChildToTreeElement(int parentID, int childID) {
        for (E parent : membersList) {
            if (parent.getId() == parentID) {
                for (E child : membersList) {
                    if (child.getId() == childID) {
                        parent.addChild(child);
                        child.addParent(parent);
                    }
                }
            }

        }

    }

    public void sortByName() {
        System.out.println("Семейное дерево отсортировано по имени");
        Collections.sort(membersList, new FTComparatorByName<>());
    }

    public void sortByAge() {
        System.out.println("Семейное дерево отсортировано по возрасту");
        Collections.sort(membersList, new FTComparatorByAge<>());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Семейное дерево:\n");
        for (E member : membersList) {
            sb.append(member);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(membersList);
    }
}
