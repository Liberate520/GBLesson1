package ru.gb.study_group.View;

import ru.gb.study_group.View.command.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu
{
    private final List<Command> commandList;

    public MainMenu(Console console) {
        commandList = new ArrayList<>();
        commandList.add(new AddStudent(console));
        commandList.add(new GetStudentListInfo(console));
        commandList.add(new SortByAge(console));
        commandList.add(new SortByName(console));
        commandList.add(new Finish(console));
    }

    public String getMenu(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(i+1);
            sb.append(". ");
            sb.append(commandList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice - 1);
        command.execute();
    }
}
