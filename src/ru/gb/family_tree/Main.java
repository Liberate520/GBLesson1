package ru.gb.family_tree;

import ru.gb.family_tree.model.Gender;
import ru.gb.family_tree.model.Person;
import ru.gb.family_tree.presenter.PresenterService;
import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.View;
import ru.gb.family_tree.writer.FileHandler;

public class Main {
    public static void main(String[] args) {

        View view = new ConsoleUI();
        view.start();



    }


}
