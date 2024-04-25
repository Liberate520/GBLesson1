package ru.gb.study_group.View.command;

import ru.gb.study_group.View.Console;

public abstract class Command {
    private final String description;
    private final Console console;

    public Command(String description, Console console) {
        this.description = description;
        this.console = console;
    }

    public String getDescription() {
        return description;
    }

    Console getConsole() {
        return console;
    }

    public abstract void execute();

}
