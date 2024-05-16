package ru.gb.family_list.view.commands;

import ru.gb.family_list.view.ConsoleUi;

public class AddHuman extends Command{

    public AddHuman(ConsoleUi cui) {
        super(cui);
    }

    @Override
    public void execute() {
        cui.addHuman();
    }
}
