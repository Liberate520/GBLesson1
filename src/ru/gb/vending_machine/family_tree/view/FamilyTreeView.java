package ru.gb.vending_machine.family_tree.view;


import ru.gb.vending_machine.family_tree.model.Person;

import java.util.List;

public interface FamilyTreeView {
    void displayMembers(List<Person> members);
    void displayMessage(String message);
}
