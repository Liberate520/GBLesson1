package ru.gb.study_group.View.command;

import ru.gb.study_group.View.Console;

public class AddStudent extends Command {

    public AddStudent(Console console) {
        super("Добавить сттудента ", console);
    }
    @Override
    public void execute(){
        getConsole().addStudent();
    }
}
