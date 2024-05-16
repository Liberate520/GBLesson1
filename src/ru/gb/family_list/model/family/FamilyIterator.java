package ru.gb.family_list.model.family;

import java.util.Iterator;
import java.util.List;

public class FamilyIterator<E extends FamilyListItem> implements Iterator<E> {

    private int index;
    private final List<E> familyList;

    FamilyIterator(List<E> familyList) {
        this.familyList = familyList;
    }

    @Override
    public boolean hasNext() {
        return index < familyList.size();
    }

    @Override
    public E next() {
        return familyList.get(index++);
    }
}
