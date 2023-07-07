package ru.gb.family_tree.human.comparator;

import ru.gb.family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByBirthday implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        if (o1.getBirthday().isAfter(o2.getBirthday())) {
            return 1;
        } else if (o1.getBirthday().isBefore(o2.getBirthday())) {
            return -1;
        } else {
            return 0;
        }
    }
}
