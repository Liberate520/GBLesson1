package ru.gb.family_tree;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.save.FileHandler;
import ru.gb.family_tree.model.save.Writable;
import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();

    }
}
