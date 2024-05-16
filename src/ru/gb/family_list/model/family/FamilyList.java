package ru.gb.family_list.model.family;

import ru.gb.family_list.model.human.Human;
import ru.gb.family_list.model.human.comparator.HumanComparatorByAge;
import ru.gb.family_list.model.human.comparator.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyList<E extends FamilyListItem> implements Serializable, Iterable<E>, Stringable {

    private final List<E> list;

    public FamilyList() {
        this.list = new ArrayList<>();
    }

    public void addHuman(E human) {
        list.add(human);
    }

    public void addHumans(E... humans) {
        for (E human : humans) {
            addHuman(human);
        }
    }

    public String getFullList() {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (E human : list) {
            sb.append("INDEX: " + index + "   " + human.toString() +"\n");
            index++;
        }
        return sb.toString();
    }

    public void showAllChildByHuman(E human) {
        if (this.list.contains(human)) {
            for (E listed_human : list) {
                if (listed_human.getFather() != null && human.getGender() == Human.Gender.MALE && listed_human.getFather().equals(human)) {
                    System.out.println(listed_human);
                }
                if (listed_human.getMother() != null && human.getGender() == Human.Gender.FEMALE && listed_human.getMother().equals(human)) {
                    System.out.println(listed_human);
                }
            }
        }
    }

    public E getHumanByIndex(Integer index) {
        if (index != null && index >= 0 && index < list.size()) {
            return list.get(index);
        }
        return null;
    };

    public void sortByAge() {
        list.sort(new HumanComparatorByAge<>());
    }

    public void sortByName () {
        list.sort(new HumanComparatorByName<>());
    }

    @Override
    public String getStringedData() {
        return getFullList();
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyIterator<>(list);
    }
}
