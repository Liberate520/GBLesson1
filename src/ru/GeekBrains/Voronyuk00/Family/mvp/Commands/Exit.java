package ru.GeekBrains.Voronyuk00.Family.mvp.Commands;

import ru.GeekBrains.Voronyuk00.Family.mvp.ConsoleUI;

public class Exit extends Commands{
 
	public Exit(ConsoleUI consoleUI) {
		super("Выход из программы", consoleUI);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		getConsoleUI().exitProgram();
	}
}
