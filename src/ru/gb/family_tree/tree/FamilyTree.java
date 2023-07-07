package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.comparator.HumanComparatorByBirthday;
import ru.gb.family_tree.human.comparator.HumanComparatorByChildren;
import ru.gb.family_tree.human.comparator.HumanComparatorByName;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class FamilyTree implements Serializable, Iterable<Human> {
    private long treeId;
    private long humanId;
    private List<Human> humanList;

    public FamilyTree() {
        this.treeId = new Random().nextInt(10000);
        this.humanList = new ArrayList<>();
        System.out.println("Зарегистрировано семейно древо: " + this.treeId);
    }

    public List<Human> getHumanList() {
        return humanList;
    }

    public Human addHuman(Human human) {
        human.setId(++humanId);
        humanList.add(human);
        System.out.println("В дерево добавлен: " + human);
        return human;
    }

    public Human getHuman(long id) {
        return humanList.stream().filter(h -> h.getId() == id).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Члена семьи с идентификатором: " + id + ", не найдено!"));
    }

    public List<Human> getHumanParents(long id) {
        return humanList.stream().filter(h -> h.getId() == id).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Члена семьи с идентификатором: " + id + ", не найдено!")).getParents();
    }

    public List<Human> getHumanChildren(long id) {
        return humanList.stream().filter(h -> h.getId() == id).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Члена семьи с идентификатором: " + id + ", не найдено!")).getChildren();
    }

    public void addParents(long id, List<Human> parents) {
        getHuman(id).setParents(parents.stream()
                .filter(h -> !getHumanParents(id).contains(h))
                .peek(h -> getHumanParents(id).add(h))
                .collect(Collectors.toList()));
        System.out.println("Список родителей у " + getHuman(id).getName() + " " + getHuman(id).getSurname()
                + " обновлен!");
    }

    public void addChildren(long id, List<Human> children) {
        getHuman(id).setChildren(children.stream()
                .filter(h -> !getHumanChildren(id).contains(h))
                .peek(h -> getHumanChildren(id).add(h))
                .collect(Collectors.toList()));
        System.out.println("Список детей у " + getHuman(id).getName() + " " + getHuman(id).getSurname()
                + " обновлен!");
    }

    public void removeHuman(long id) {
        getHumanList().stream()
                .peek(h -> {
                    if (h.getParents().contains(getHuman(id))) {
                        h.getParents().remove(h);
                    }
                });
        getHumanList().stream()
                .peek(h -> {
                    if (h.getChildren().contains(getHuman(id))) {
                        h.getChildren().remove(h);
                    }
                });
        getHumanList().stream()
                .peek(h -> {
                    if (h.getId() == id) {
                        getHumanList().remove(h);
                    }
                });
        System.out.println("Член семьи с идентификатором: " + id + ", удален!");
    }

    public void addSpouse(long id1, long id2) {
        if (getHuman(id1).getSpouse() == null) {
            if (getHuman(id2).getSpouse() == null) {
                getHuman(id2).setSpouse(getHuman(id1));
            } else if (getHuman(id2).getSpouse().getId() != id1) {
                System.out.println(getHuman(id2).getName() + " " + getHuman(id2).getSurname()
                        + " находится в браке c другим человеком!");
            }
            getHuman(id1).setSpouse(getHuman(id2));
            System.out.println("Добавлена запись брака: "
                    + getHuman(id1).getName() + " " + getHuman(id1).getSurname()
                    + " и " + getHuman(id2).getName() + " " + getHuman(id2).getSurname());
        } else {
            System.out.println(getHuman(id1).getName() + " " + getHuman(id1).getSurname() + " находится в браке!");
        }
    }

    public void removeSpouse(long id) {
        if (getHuman(id).getSpouse() != null) {
            if ((getHuman(getHuman(id).getSpouse().getId()).getSpouse() != null)
                    && ((getHuman(getHuman(id).getSpouse().getId()).getSpouse().getId() == id))) {
                getHuman(getHuman(id).getSpouse().getId()).setSpouse(null);
            }
            getHuman(id).setSpouse(null);
        }
        System.out.println("Брак " + getHuman(id).getName() + " " + getHuman(id).getSurname() + " расторгнут!");
    }

    public List<Human> getHumanWithSortByBirthday() {
        return humanList.stream().sorted(new HumanComparatorByBirthday()).collect(Collectors.toList());
    }

    public List<Human> getHumanWithSortByChildren() {
        return humanList.stream().sorted(new HumanComparatorByChildren()).collect(Collectors.toList());
    }

    public List<Human> getHumanWithSortByName() {
        return humanList.stream().sorted(new HumanComparatorByName()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "treeId=" + treeId +
                '}';
    }

    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator(humanList);
    }
}
