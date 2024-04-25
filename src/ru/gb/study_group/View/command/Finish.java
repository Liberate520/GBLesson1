package ru.gb.study_group.View.command;

import ru.gb.study_group.View.Console;

public class Finish extends Command{

    public Finish(Console console){
        super("Закончить работу ", console);
    }

    @Override
    public void execute() {
        getConsole().finish();
    }
}
