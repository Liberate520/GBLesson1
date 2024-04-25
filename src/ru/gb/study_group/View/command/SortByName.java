package ru.gb.study_group.View.command;

import ru.gb.study_group.View.Console;

public class SortByName extends Command {

    public SortByName(Console console){
        super ("Отсортировать по имени ", console);
    }

    @Override
    public void execute() {
        getConsole().sortByName();
    }
}
