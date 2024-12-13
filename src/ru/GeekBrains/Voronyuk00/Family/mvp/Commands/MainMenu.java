package ru.GeekBrains.Voronyuk00.Family.mvp.Commands;

import java.util.ArrayList;
import java.util.List;

import ru.GeekBrains.Voronyuk00.Family.mvp.ConsoleUI;

public class MainMenu {
	List<Commands> commands;
	
	public MainMenu(ConsoleUI consoleUI) {
		commands = new ArrayList<>();
		commands.add(new AddPerson(consoleUI));
		commands.add(new GetFamilyList(consoleUI));
		commands.add(new SortByName(consoleUI));
		commands.add(new SortByBirthDate(consoleUI));
		commands.add(new Exit(consoleUI));
	}
	
	public String menu() {
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0;i < commands.size();i++) {
			stringBuilder.append(i + 1 + ". ");
			stringBuilder.append(commands.get(i).getDescription());
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
	
	public void execute(int choice) {
		commands.get(choice-1).execute();
	}
}
