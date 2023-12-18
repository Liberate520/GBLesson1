package ru.gb.family_tree.view.comandsMenu;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByAge extends Menu {

    public SortByAge(ConsoleUI consoleUI) {
        super("Отсортировать семейное дерево по возрасту", consoleUI);
    }

    public void action() {
        getConsoleUI().sortByAge();
    }

}