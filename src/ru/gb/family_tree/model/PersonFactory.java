package ru.gb.family_tree.model;

import ru.gb.family_tree.model.family_tree.TreeNode;
import ru.gb.family_tree.model.human.Gender;

import java.time.LocalDate;

public interface PersonFactory <T extends TreeNode<T>> {
    T createPerson(String name, Gender gender, LocalDate birthDate);
}