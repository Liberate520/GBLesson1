package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.View;

public class SaveToFile extends Command {
    public SaveToFile(View consoleUI) {
        super(consoleUI);
        description = "Сохранить в файл";
    }

    @Override
    public void execute() {
        consoleUI.saveToFile();
    }
}
