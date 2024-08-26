package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByBirthDay extends Command {
    public SortByBirthDay(ConsoleUI consoleUI) {
        super("Отсортировать по дате рождения", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByBirthDay();
    }
}
