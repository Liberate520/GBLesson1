package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SaveToFile extends Command {
    public SaveToFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить в файл";
    }

    @Override
    public void execute() {
        consoleUI.saveToFile();
    }
}
