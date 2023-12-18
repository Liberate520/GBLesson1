package ru.gb.family_tree.view.comandsMenu;

import ru.gb.family_tree.view.ConsoleUI;

public class SetDeathDate extends Menu {

    public SetDeathDate(ConsoleUI consoleUI) {
        super("Указать дату смерти", consoleUI);
    }

    public void action() {
        getConsoleUI().setDeathDate();
    }

}