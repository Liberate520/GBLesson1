package ru.gb.family_tree.view.comandsMenu;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByName extends Menu {

    public SortByName(ConsoleUI consoleUI) {
        super("Отсортировать семейное дерево по имени", consoleUI);
    }

    public void action() {
        getConsoleUI().sortByName();
    }

}