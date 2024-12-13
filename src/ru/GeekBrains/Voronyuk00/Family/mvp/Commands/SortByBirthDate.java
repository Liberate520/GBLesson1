package ru.GeekBrains.Voronyuk00.Family.mvp.Commands;

import ru.GeekBrains.Voronyuk00.Family.mvp.ConsoleUI;

public class SortByBirthDate extends Commands{

	public SortByBirthDate(ConsoleUI consoleUI) {
		super("Отсортировать по дате рождения", consoleUI);
	}
	
	@Override
	public void execute() {
		getConsoleUI().sortByBirthDate();
	}
	
}
