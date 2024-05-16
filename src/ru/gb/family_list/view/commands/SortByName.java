package ru.gb.family_list.view.commands;

import ru.gb.family_list.view.ConsoleUi;

public class SortByName extends Command{

    public SortByName(ConsoleUi cui) {
        super(cui);
    }

    @Override
    public void execute() {
        cui.sortByName();
    }
}
