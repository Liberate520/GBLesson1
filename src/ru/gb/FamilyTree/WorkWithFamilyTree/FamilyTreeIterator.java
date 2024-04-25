package ru.gb.FamilyTree.WorkWithFamilyTree;

import ru.gb.FamilyTree.Human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<E extends FamilyTreeElem> implements Iterator<E> {
    private List<E> familyTree;
    private int index;

    public FamilyTreeIterator(List<E> familyTree) {
        this.familyTree = familyTree;
    }


    @Override
    public boolean hasNext() {
        return index < familyTree.size();
    }

    @Override
    public E next() {
        return familyTree.get(index++);
    }


}
