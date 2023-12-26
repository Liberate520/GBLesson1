package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.View;

public abstract class Command {
    String description;
    View consoleUI;

    public Command(View consoleUI) {
        this.consoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}