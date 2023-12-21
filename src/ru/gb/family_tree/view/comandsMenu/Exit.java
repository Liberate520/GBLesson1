package ru.gb.family_tree.view.comandsMenu;

import ru.gb.family_tree.view.ConsoleUI;

public class Exit extends Menu {

    public Exit(ConsoleUI consoleUI) {
        super("Выход", consoleUI);
    }

    public void action() {
        getConsoleUI().exit();
    }

}
