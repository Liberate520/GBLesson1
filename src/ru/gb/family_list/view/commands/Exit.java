package ru.gb.family_list.view.commands;

import ru.gb.family_list.view.ConsoleUi;

public class Exit extends Command{
    public Exit(ConsoleUi cui) {
        super(cui);
    }

    @Override
    public void execute() {
        cui.finish();
    }
}
