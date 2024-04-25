package ru.gb.study_group.View.command;

import ru.gb.study_group.View.Console;

public class GetStudentListInfo extends Command{
    public GetStudentListInfo(Console console) {
        super("Получить список студентов", console);
    }

    @Override
    public void execute() {
        getConsole().getstudentListInfo();
    }
}
