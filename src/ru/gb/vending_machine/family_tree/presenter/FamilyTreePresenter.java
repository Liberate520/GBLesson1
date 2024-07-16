package ru.gb.vending_machine.family_tree.presenter;


import ru.gb.vending_machine.family_tree.model.FamilyTree;
import ru.gb.vending_machine.family_tree.model.Person;
import ru.gb.vending_machine.family_tree.service.FamilyTreeFileManagerImpl;
import ru.gb.vending_machine.family_tree.utils.FamilyTreeFileManager;
import ru.gb.vending_machine.family_tree.view.FamilyTreeView;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class FamilyTreePresenter {
    private FamilyTree<Person> familyTree;
    private final FamilyTreeView view;
    private final FamilyTreeFileManager<Person> fileManager;

    public FamilyTreePresenter(FamilyTreeView view) {
        this.view = view;
        this.familyTree = new FamilyTree<>();
        this.fileManager = new FamilyTreeFileManagerImpl<>();
    }

    public void addPerson(Person person) {
        familyTree.addMember(person.getName(), person);
        view.displayMessage("Added person: " + person);
    }

    public void displayFamilyTree() {
        view.displayMembers(familyTree.getAllMembers());
    }

    public void displaySortedByName() {
        List<Person> sortedMembers = familyTree.getMembersSortedByName(Comparator.comparing(Person::getName));
        view.displayMembers(sortedMembers);
    }

    public void displaySortedByBirthDate() {
        List<Person> sortedMembers = familyTree.getMembersSortedByBirthDate(Comparator.comparing(Person::getBirthDate));
        view.displayMembers(sortedMembers);
    }

    public void saveFamilyTree(String fileName) {
        try {
            fileManager.saveFamilyTree(familyTree, fileName);
            view.displayMessage("Family tree saved to " + fileName);
        } catch (IOException e) {
            view.displayMessage("Failed to save family tree: " + e.getMessage());
        }
    }

    public void loadFamilyTree(String fileName) {
        try {
            familyTree = fileManager.loadFamilyTree(fileName);
            view.displayMessage("Family tree loaded from " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            view.displayMessage("Failed to load family tree: " + e.getMessage());
        }
    }
}

