package ru.gb.family_list.view.commands;

import ru.gb.family_list.view.ConsoleUi;

import java.io.IOException;

public class Save extends Command{
    public Save(ConsoleUi cui) {
        super(cui);
    }

    @Override
    public void execute() {
        cui.save();
    }
}
