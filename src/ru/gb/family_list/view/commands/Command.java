package ru.gb.family_list.view.commands;

import ru.gb.family_list.view.ConsoleUi;

import java.io.IOException;

public abstract class Command {
    ConsoleUi cui;

    public Command(ConsoleUi cui) {
        this.cui = cui;
    }

    public abstract void execute() throws IOException, ClassNotFoundException;
}
