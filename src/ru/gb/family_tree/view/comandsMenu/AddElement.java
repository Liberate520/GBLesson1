package ru.gb.family_tree.view.comandsMenu;

import ru.gb.family_tree.view.ConsoleUI;

public class AddElement extends Menu {

    public AddElement(ConsoleUI consoleUI) {
        super("Добавить элемент в семейное дерево", consoleUI);
    }

    public void action() {
        getConsoleUI().addElement();
    }

}
