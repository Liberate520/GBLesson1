package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.HumanIterator;

import java.io.Serializable;
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

    public boolean isEmpty() {
        if (membersList.isEmpty()) {
            return true;
        }
        return false;
    }

    public void sortByName() {
        System.out.println("Family tree sorted by Name");
        Collections.sort(membersList, new FTComparatorByName<>());
    }

    public void sortByAge() {
        System.out.println("Family tree sorted by Age");
        Collections.sort(membersList, new FTComparatorByAge<>());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Family Tree:\n");
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
