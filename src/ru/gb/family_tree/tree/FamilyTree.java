package ru.gb.family_tree.tree;

import ru.gb.family_tree.tree_elements.Fundamental;
import ru.gb.family_tree.tree_elements.Human;
import ru.gb.family_tree.tree_elements.comparator.ElementsComparatorByBirthday;
import ru.gb.family_tree.tree_elements.comparator.ElementsComparatorByChildren;
import ru.gb.family_tree.tree_elements.comparator.ElementsComparatorByName;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class FamilyTree<E extends Fundamental<E>> implements Serializable, Iterable<E> {
    private long treeId;
    private long elementId;
    private List<E> elementList;

    public FamilyTree() {
        this.treeId = new Random().nextInt(10000);
        this.elementList = new ArrayList<>();
        System.out.println("Зарегистрировано семейно древо: " + this.treeId);
    }

    public List<E> getElementList() {
        return elementList;
    }

    public E addHuman(E e) {
        e.setId(++elementId);
        elementList.add(e);
        System.out.println("В дерево добавлен: " + e);
        return e;
    }

    public E getElement(long id) {
        return elementList.stream().filter(h -> h.getId() == id).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Члена семьи с идентификатором: " + id + ", не найдено!"));
    }

    public List<E> getParents(long id) {
        return elementList.stream().filter(h -> h.getId() == id).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Члена семьи с идентификатором: " + id + ", не найдено!")).getParents();
    }

    public List<E> getChildren(long id) {
        return elementList.stream().filter(h -> h.getId() == id).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Члена семьи с идентификатором: " + id + ", не найдено!")).getChildren();
    }

    public void addParents(long id, List<E> parents) {
        getElement(id).setParents(parents.stream()
                .filter(h -> !getParents(id).contains(h))
                .peek(h -> getParents(id).add(h))
                .collect(Collectors.toList()));
        System.out.println("Список родителей у " + getElement(id).getName() + " обновлен!");
    }

    public void addChildren(long id, List<E> children) {
        getElement(id).setChildren(children.stream()
                .filter(h -> !getChildren(id).contains(h))
                .peek(h -> getChildren(id).add(h))
                .collect(Collectors.toList()));
        System.out.println("Список детей у " + getElement(id).getName() + " обновлен!");
    }

    public void removeHuman(long id) {
        getElementList().stream()
                .peek(h -> {
                    if (h.getParents().contains(getElement(id))) {
                        h.getParents().remove(h);
                    }
                });
        getElementList().stream()
                .peek(h -> {
                    if (h.getChildren().contains(getElement(id))) {
                        h.getChildren().remove(h);
                    }
                });
        getElementList().stream()
                .peek(h -> {
                    if (h.getId() == id) {
                        getElementList().remove(h);
                    }
                });
        System.out.println("Член семьи с идентификатором: " + id + ", удален!");
    }

    public void addSpouse(long id1, long id2) {
        if (getElement(id1).getSpouse() == null) {
            if (getElement(id2).getSpouse() == null) {
                getElement(id2).setSpouse(getElement(id1));
            } else if (getElement(id2).getSpouse().getId() != id1) {
                System.out.println(getElement(id2).getName() + " уже в отношениях!");
            }
            getElement(id1).setSpouse(getElement(id2));
            System.out.println("Добавлена запись отношений: "
                    + getElement(id1).getName() + " и " + getElement(id2).getName());
        } else {
            System.out.println(getElement(id1).getName() + " находится в отношениях!");
        }
    }

    public void removeSpouse(long id) {
        if (getElement(id).getSpouse() != null) {
            Human spouse = (Human) getElement(id).getSpouse();
            if ((spouse != null) && (spouse.getId() == id)) {
                getElement(spouse.getId()).setSpouse(null);
            }
            getElement(id).setSpouse(null);
        }
        System.out.println("Отношения " + getElement(id).getName() + " прекращены!");
    }

    public List<E> getHumanWithSortByBirthday() {
        return (List<E>) elementList.stream().sorted(new ElementsComparatorByBirthday()).collect(Collectors.toList());
    }

    public List<E> getHumanWithSortByChildren() {
        return (List<E>) elementList.stream().sorted(new ElementsComparatorByChildren()).collect(Collectors.toList());
    }

    public List<E> getHumanWithSortByName() {
        return (List<E>) elementList.stream().sorted(new ElementsComparatorByName()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "treeId=" + treeId +
                '}';
    }

    @Override
    public Iterator<E> iterator() {
        FamilyTreeIterator<E> fi = new FamilyTreeIterator<>(elementList);
        return fi;
    }
}
