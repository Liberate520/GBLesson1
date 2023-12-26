package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.View;

public class SortByName extends Command{
    public SortByName(View consoleUI) {
        super(consoleUI);
        description = "Сортировка по имени";
    }

    @Override
    public void execute() {
        consoleUI.sortByName();
    }
}
