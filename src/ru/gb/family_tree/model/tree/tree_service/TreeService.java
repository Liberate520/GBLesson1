package ru.gb.family_tree.model.tree.tree_service;

import ru.gb.family_tree.model.tree.FamilyTree;
import ru.gb.family_tree.model.tree_elements.Fundamental;
import ru.gb.family_tree.model.tree_elements.comparator.ElementsComparatorByBirthday;
import ru.gb.family_tree.model.tree_elements.comparator.ElementsComparatorByChildren;
import ru.gb.family_tree.model.tree_elements.comparator.ElementsComparatorByName;

import java.util.List;
import java.util.stream.Collectors;

public class TreeService<E extends Fundamental<E>> implements BaseFunctions<E>, SortFunctions<E> {

    private FamilyTree<E> familyTree;

    public TreeService(FamilyTree<E> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public E addElement(E e) {
        long id = familyTree.getElementId();
        id++;
        e.setId(id);
        familyTree.setElementId(id);
        familyTree.getElementList().add(e);
        System.out.println("В дерево добавлен: " + e);
        return e;
    }

    @Override
    public E getElement(long id) {
        return familyTree.getElementList().stream().filter(e -> e.getId() == id).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Члена семьи с идентификатором: " + id + ", не найдено!"));
    }

    @Override
    public void addParents(long id, List<E> parents) {
        getElement(id).setParents(parents.stream()
                .filter(e -> !getParents(id).contains(e))
                .peek(e -> getParents(id).add(e))
                .collect(Collectors.toList()));
        System.out.println("Список родителей у " + getElement(id).getName() + " обновлен!");
    }

    @Override
    public List<E> getParents(long id) {
        return familyTree.getElementList().stream().filter(e -> e.getId() == id).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Члена семьи с идентификатором: " + id + ", не найдено!")).getParents();
    }

    @Override
    public void addChildren(long id, List<E> children) {
        getElement(id).setChildren(children.stream()
                .filter(e -> !getChildren(id).contains(e))
                .peek(e -> getChildren(id).add(e))
                .collect(Collectors.toList()));
        System.out.println("Список детей у " + getElement(id).getName() + " обновлен!");
    }

    @Override
    public List<E> getChildren(long id) {
        return familyTree.getElementList().stream().filter(e -> e.getId() == id).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Члена семьи с идентификатором: " + id + ", не найдено!")).getChildren();
    }

    @Override
    public void removeItem(long id) {
        familyTree.getElementList().stream()
                .peek(e -> {
                    if (e.getParents().contains(getElement(id))) {
                        e.getParents().remove(e);
                    }
                });
        familyTree.getElementList().stream()
                .peek(e -> {
                    if (e.getChildren().contains(getElement(id))) {
                        e.getChildren().remove(e);
                    }
                });
        familyTree.getElementList().stream()
                .peek(e -> {
                    if (e.getId() == id) {
                        familyTree.getElementList().remove(e);
                    }
                });
        System.out.println("Член семьи с идентификатором: " + id + ", удален!");
    }

    @Override
    public void addSpouse(long id1, long id2) {
        if (checkSpouse(id1)) {
            if (checkSpouse(id2)) {
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

    @Override
    public void removeSpouse(long id) {
        if (checkSpouse(id)) {
            Fundamental<E> spouse = getElement(id).getSpouse();
            if ((spouse != null) && (spouse.getId() == id)) {
                getElement(spouse.getId()).setSpouse(null);
            }
            getElement(id).setSpouse(null);
        }
        System.out.println("Отношения " + getElement(id).getName() + " прекращены!");
    }

    @Override
    public List<E> SortByName() {
        return familyTree.getElementList().stream().sorted(new ElementsComparatorByName<>()).collect(Collectors.toList());
    }

    @Override
    public List<E> SortByBirthday() {
        return familyTree.getElementList().stream().sorted(new ElementsComparatorByBirthday<>()).collect(Collectors.toList());
    }

    @Override
    public List<E> SortByChildren() {
        return familyTree.getElementList().stream().sorted(new ElementsComparatorByChildren<>()).collect(Collectors.toList());
    }

    private boolean checkSpouse(long id) {
        return (getElement(id).getSpouse() == null);
    }

    public FamilyTree<E> getFamilyTree() {
        return familyTree;
    }

    public void setFamilyTree(FamilyTree<E> familyTree) {
        this.familyTree = familyTree;
    }
}
