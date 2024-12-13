package ru.GeekBrains.Voronyuk00.Family.mvp.Commands;

import ru.GeekBrains.Voronyuk00.Family.mvp.ConsoleUI;

public class GetFamilyList extends Commands{

	public GetFamilyList(ConsoleUI consoleUI) {
		super("Вывести список всех членов семьи", consoleUI);
	}
	
	@Override
	public void execute() {
		getConsoleUI().getFamilyList();
	}
	
}
