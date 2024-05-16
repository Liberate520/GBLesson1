package ru.gb.family_list.view.commands;

import ru.gb.family_list.view.ConsoleUi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CommandsList {
    private List<Command> commandsList;

    public CommandsList(ConsoleUi cui) {
        commandsList = new ArrayList<>();
        commandsList.add(new AddHuman(cui));
        commandsList.add(new GetFullFamilyList(cui));
        commandsList.add(new SortByName(cui));
        commandsList.add(new SortByAge(cui));
        commandsList.add(new Save(cui));
        commandsList.add(new Read(cui));
        commandsList.add(new Exit(cui));
    }

    public List<Command> getCommands() {
        return commandsList;
    }

    public String getStringCommands(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commandsList.size(); i++) {
            sb.append(i+1 + ": ");
            sb.append(commandsList.get(i).getClass().getSimpleName());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(Integer command) throws IOException, ClassNotFoundException {
        commandsList.get(command).execute();
    }
}
