package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.View;

public class GetInfo extends Command {
    public GetInfo(View consoleUI) {
        super(consoleUI);
        description = "Получить информацию о семейном дереве";
    }

    @Override
    public void execute() {

        consoleUI.getFamilyTreeInfo();
            }
}
