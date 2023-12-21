package ru.gb.family_tree.view.comandsMenu;

import ru.gb.family_tree.view.ConsoleUI;

public class AddChildTo extends Menu {

    public AddChildTo(ConsoleUI consoleUI) {
        super("Добавить ребенка к элементу семейного дерева", consoleUI);
    }

    public void action() {
        getConsoleUI().addChildTo();
    }

}