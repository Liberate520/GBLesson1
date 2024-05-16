package ru.gb.family_list.view.commands;

import ru.gb.family_list.view.ConsoleUi;

public class SortByAge extends Command{

    public SortByAge(ConsoleUi cui) {
        super(cui);
    }

    @Override
    public void execute() {
        cui.sortByAge();
    }
}
