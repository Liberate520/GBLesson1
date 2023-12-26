package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.model.Person;
import ru.gb.family_tree.view.ConsoleUI;

public class AddPerson extends Command {

    public AddPerson(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить студента";

    }

    @Override
    public void execute() {
        consoleUI.print("Введите имя");
        String name = consoleUI.read();
        consoleUI.print("Введите пол. Если женский то Ж, если мужской то Ж");
        String sGender = consoleUI.read();
        consoleUI.addFamilyTreeMember(name, sGender);
        consoleUI.printf("Член семейного дерева %s добавлен\n", name);
    }

}
