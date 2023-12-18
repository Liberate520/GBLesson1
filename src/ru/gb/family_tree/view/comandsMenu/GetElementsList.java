package ru.gb.family_tree.view.comandsMenu;

import ru.gb.family_tree.view.ConsoleUI;

public class GetElementsList extends Menu {

    public GetElementsList(ConsoleUI consoleUI) {
        super("Получить список элементов семейного дерева", consoleUI);
    }

    public void action() {
        getConsoleUI().getElementsList();
    }

}