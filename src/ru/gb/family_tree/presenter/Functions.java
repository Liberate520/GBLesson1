package ru.gb.family_tree.presenter;

import ru.gb.family_tree.presenter.commands.Commands;

public interface Functions {
    void createCommands();
    Commands chooseCommand(String line);
    void doCommand(String line);
}
