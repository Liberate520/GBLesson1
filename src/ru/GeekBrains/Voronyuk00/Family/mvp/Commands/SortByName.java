package ru.GeekBrains.Voronyuk00.Family.mvp.Commands;

import ru.GeekBrains.Voronyuk00.Family.mvp.ConsoleUI;

public class SortByName extends Commands {
	
	public SortByName(ConsoleUI consoleUI) {
		super("Отсортировать по имени", consoleUI);
	}
	
	@Override
	public void execute() {
		getConsoleUI().sortByName();
	}
}
