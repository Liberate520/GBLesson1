package ru.gb.family_tree.view;

import ru.gb.family_tree.view.comandsMenu.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Menu> commandsMenu;

    public MainMenu(ConsoleUI consoleUI) {
        commandsMenu = new ArrayList<>();
        commandsMenu.add(new AddElement(consoleUI));
        commandsMenu.add(new GetElementsList(consoleUI));
        commandsMenu.add(new AddChildTo(consoleUI));
        commandsMenu.add(new SetDeathDate(consoleUI));
        commandsMenu.add(new SortByName(consoleUI));
        commandsMenu.add(new SortByAge(consoleUI));
        commandsMenu.add(new Save(consoleUI));
        commandsMenu.add(new Load(consoleUI));
        commandsMenu.add(new Exit(consoleUI));
    }

    public String menuElements() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandsMenu.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandsMenu.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void action(int choice) {
        Menu menu = commandsMenu.get(choice - 1);
        menu.action();
    }

    public int size(){
        return commandsMenu.size();
    }
}
