package ru.gb.family_tree.iterators;

import java.util.Iterator;
import java.util.List;

public class MemberIterator<T> implements Iterator<T> {
    private int index = 0;
    private final  List<T> listMembers;

    public MemberIterator(List<T> listMembers) {
        this.listMembers = listMembers;
    }

    @Override
    public boolean hasNext() {
        return index < listMembers.size();
    }

    @Override
    public T next() {
        return listMembers.get(index++);
    }
}
