package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.View;

public class LoadFromFile extends Command {
    public LoadFromFile(View consoleUI) {
        super(consoleUI);
        description = "Загрузить из файла";
    }

    @Override
    public void execute() {
        consoleUI.loadFromFile();
    }
}
