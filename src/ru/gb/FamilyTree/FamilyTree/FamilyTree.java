package ru.gb.FamilyTree.FamilyTree;

import ru.gb.FamilyTree.Human.Human;
import ru.gb.FamilyTree.WorkWithFamilyTree.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeElem<E>> implements Serializable, Iterable<E> {
    private List<E> humanList;


    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public void addMember(E human) {
        if (!humanList.contains(human)) {
            humanList.add(human);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FamilyTree{ \n");
        for (E human : humanList) {
            sb.append(human.getInfo()).append("\n");
        }

        sb.append('}');
        return sb.toString();
    }

    public void saveToFile() {

    }

    public void sortByName() {
        humanList.sort(new FamilyTreeComporatorByName<>());

    }


    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(humanList);
    }


    public void sortByAge() {
        humanList.sort(new FamilyTreeComporatorByAge<>());
    }
}

