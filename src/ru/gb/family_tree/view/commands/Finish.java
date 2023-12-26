package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.View;

public class Finish extends Command {
    public Finish(View consoleUI) {
        super(consoleUI);
        description = "Закончить работу";
    }

    @Override
    public void execute() {
        consoleUI.finish();
    }
}
