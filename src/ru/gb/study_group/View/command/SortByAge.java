package ru.gb.study_group.View.command;

import ru.gb.study_group.View.Console;

public class SortByAge extends  Command{
    public SortByAge(Console console){
        super("Отсортировать по возрасту ", console);
    }

    @Override
    public void execute() {
        getConsole().sortByAge();
    }
}
