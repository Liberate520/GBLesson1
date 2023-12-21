package ru.gb.family_tree.view.comandsMenu;

import ru.gb.family_tree.view.ConsoleUI;

public class Load extends Menu {

    public Load(ConsoleUI consoleUI) {
        super("Загрузить семейное дерево", consoleUI);
    }

    public void action() {
        getConsoleUI().load();
    }

}
