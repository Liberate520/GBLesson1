package ru.gb.family_tree.model.tree;

import ru.gb.family_tree.model.tree_elements.Fundamental;
import ru.gb.family_tree.model.tree_elements.Item;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<E extends Fundamental<E>> implements Serializable, Iterable<E> {

    private long treeId;
    private long elementId;
    private List<E> elementList;

    public FamilyTree() {
        this.treeId = new Random().nextInt(10000);
        this.elementList = new ArrayList<>();
        System.out.println("Зарегистрировано семейно древо: " + this.treeId);
    }

    public long getElementId() {
        return elementId;
    }

    public void setElementId(long elementId) {
        this.elementId = elementId;
    }

    public List<E> getElementList() {
        return elementList;
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "treeId=" + treeId +
                '}';
    }

    @Override
    public Iterator<E> iterator() {
        FamilyTreeIterator<E> fi = new FamilyTreeIterator<>(elementList);
        return fi;
    }
}
