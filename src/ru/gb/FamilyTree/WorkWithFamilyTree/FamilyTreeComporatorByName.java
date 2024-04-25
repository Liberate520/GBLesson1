package ru.gb.FamilyTree.WorkWithFamilyTree;

import java.util.Comparator;

public class FamilyTreeComporatorByName<E extends FamilyTreeElem> implements Comparator<E>{






    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
