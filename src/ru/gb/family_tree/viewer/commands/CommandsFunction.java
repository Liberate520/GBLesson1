package ru.gb.family_tree.viewer.commands;

public interface CommandsFunction {
    void createCommands();
    Commands chooseCommand(String line);
    void doCommand(String line);
}
