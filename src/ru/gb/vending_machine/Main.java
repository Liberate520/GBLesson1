package ru.gb.vending_machine;

import ru.gb.vending_machine.family_tree.model.Gender;
import ru.gb.vending_machine.family_tree.model.Person;
import ru.gb.vending_machine.family_tree.presenter.FamilyTreePresenter;
import ru.gb.vending_machine.family_tree.view.FamilyTreeConsoleView;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTreeConsoleView view = new FamilyTreeConsoleView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(view);

        Person john = new Person("John", Gender.MALE, LocalDate.of(1970, 1, 1));
        Person jane = new Person("Jane", Gender.FEMALE, LocalDate.of(1975, 5, 5));
        Person paul = new Person("Paul", Gender.MALE, LocalDate.of(2000, 10, 10));
        Person anna = new Person("Anna", Gender.FEMALE, LocalDate.of(2005, 8, 20));

        john.addChild(paul);
        john.addChild(anna);
        jane.addChild(paul);
        jane.addChild(anna);

        presenter.addPerson(john);
        presenter.addPerson(jane);
        presenter.addPerson(paul);
        presenter.addPerson(anna);

        // Установим дату смерти для John
        john.setDeathDate(LocalDate.of(2020, 1, 1));

        view.displayMessage("Children of John:");
        for (Person child : john.getChildren()) {
            view.displayMessage(child.toString());
        }

        view.displayMessage("\nFamily Tree:");
        presenter.displayFamilyTree();

        view.displayMessage("\nPeople sorted by name:");
        presenter.displaySortedByName();

        view.displayMessage("\nPeople sorted by birth date:");
        presenter.displaySortedByBirthDate();

        String fileName = "familyTree.ser";

        presenter.saveFamilyTree(fileName);
        presenter.loadFamilyTree(fileName);

        view.displayMessage("\nLoaded Family Tree:");
        presenter.displayFamilyTree();
    }
}




