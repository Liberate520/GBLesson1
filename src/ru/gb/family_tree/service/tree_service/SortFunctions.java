package ru.gb.family_tree.service.tree_service;

import ru.gb.family_tree.model.tree_elements.Fundamental;

import java.util.List;

public interface SortFunctions <E extends Fundamental>{
     List<E> SortByName();
     List<E> SortByBirthday();
     List<E> SortByChildren();
}
