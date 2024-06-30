package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddChildern extends Command {
    public AddChildern(ConsoleUI consoleUI) {
        super("Добавить ребенка: ", consoleUI);
    }
    @Override
    public void execute(){
        getConsoleUI().addChildren();
    };

}
