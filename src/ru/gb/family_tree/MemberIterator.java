package ru.gb.family_tree;

import java.util.Iterator;
import java.util.List;

public class MemberIterator<T> implements Iterator<T> {
    private int index = 0;
    private List<T> listPerson;

    public MemberIterator(List<T> listPerson) {
        this.listPerson = listPerson;
    }

    @Override
    public boolean hasNext() {
        return index < listPerson.size();
    }

    @Override
    public T next() {
        return listPerson.get(index++);
    }
}
