package ru.gb.family_list.view.commands;

import ru.gb.family_list.view.ConsoleUi;

public class GetFullFamilyList extends Command{
    public GetFullFamilyList(ConsoleUi cui) {
        super(cui);
    }

    @Override
    public void execute() {
        cui.getFullList();
    }
}
