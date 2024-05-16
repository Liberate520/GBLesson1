package ru.gb.family_list;

import ru.gb.family_list.model.family.FamilyList;
import ru.gb.family_list.model.family.FamilyListItem;
import ru.gb.family_list.model.human.Human;
import ru.gb.family_list.view.ConsoleUi;
import ru.gb.family_list.view.View;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new ConsoleUi();
        view.start();
    }
}
