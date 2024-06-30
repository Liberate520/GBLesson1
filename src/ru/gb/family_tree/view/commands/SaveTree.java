package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SaveTree extends Command {
    public SaveTree(ConsoleUI consoleUI) {
        super("Записть дерево в файл: ", consoleUI);
    }
    @Override
    public void execute(){
        getConsoleUI().saveTree();
    };

}
