package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class GetInfo extends Command {
    public GetInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить информацию о семейном дереве";
    }

    @Override
    public void execute() {

        consoleUI.getFamilyTreeInfo();
            }
}
