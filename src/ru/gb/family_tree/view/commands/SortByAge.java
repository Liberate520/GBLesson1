package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.View;

public class SortByAge extends Command {
    public SortByAge(View consoleUI) {
        super(consoleUI);
        description = "Сортировка по возрасту";
    }

    @Override
    public void execute() {
        consoleUI.sortByAge();
    }
}
