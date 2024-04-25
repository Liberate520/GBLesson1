package ru.gb.FamilyTree.WorkWithFamilyTree;

import ru.gb.FamilyTree.Human.Human;

import java.util.Comparator;

public class HumanComporator implements Comparator<Human> {


    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }


}
