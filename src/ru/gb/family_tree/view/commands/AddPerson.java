package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.View;

public class AddPerson extends Command {

    public AddPerson(View consoleUI) {
        super(consoleUI);
        description = "Добавить члена фамильного дерева";

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
