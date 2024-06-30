package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class GetInfo extends Command{

    public GetInfo(ConsoleUI consoleUI) {
        super("Получить список людей: ", consoleUI);
    }
    @Override
    public void execute(){
        getConsoleUI().getInfo();
    };

}