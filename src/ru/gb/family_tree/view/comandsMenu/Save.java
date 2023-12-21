package ru.gb.family_tree.view.comandsMenu;

import ru.gb.family_tree.view.ConsoleUI;

public class Save extends Menu {

    public Save(ConsoleUI consoleUI) {
        super("Сохранить семейное дерево", consoleUI);
    }

    public void action() {
        getConsoleUI().save();
    }

}