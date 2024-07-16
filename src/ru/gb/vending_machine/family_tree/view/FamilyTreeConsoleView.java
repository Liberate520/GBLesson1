package ru.gb.vending_machine.family_tree.view;


import ru.gb.vending_machine.family_tree.model.Person;

import java.util.List;

public class FamilyTreeConsoleView implements FamilyTreeView {

    @Override
    public void displayMembers(List<Person> members) {
        for (Person member : members) {
            System.out.println(member);
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
}

