package ru.gb.study_group;

import ru.gb.study_group.Model.Service.Service;
import ru.gb.study_group.View.Console;
import ru.gb.study_group.View.View;

public class Main {
    public static void main(String[] args) {
        View view = new Console();
        Console console = new Console();
        view.start();

    }
}
