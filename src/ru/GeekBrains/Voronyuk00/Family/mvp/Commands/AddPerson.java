package ru.GeekBrains.Voronyuk00.Family.mvp.Commands;

import ru.GeekBrains.Voronyuk00.Family.mvp.ConsoleUI;

public class AddPerson extends Commands {

	public AddPerson(ConsoleUI consoleUI) {
		super("Добавить члена семьи",consoleUI);
	}
	
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		getConsoleUI().addPerson();
	}
	
}
