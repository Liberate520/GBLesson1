package ru.GeekBrains.Voronyuk00.Family.mvp.Commands;

import ru.GeekBrains.Voronyuk00.Family.mvp.ConsoleUI;
/*
 * Класс для создания команд
 */
public abstract class Commands {
	
	private String description;
	private ConsoleUI consoleUI;
	
	public Commands(String description, ConsoleUI consoleUI) {
		this.description = description;
		this.consoleUI = consoleUI;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	ConsoleUI getConsoleUI() {
		return consoleUI;
	}
	
	public abstract void execute();
}
