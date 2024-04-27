package family_tree.model;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.presenter.Presenter;
import family_tree.model.view.ConsoleUI;
import family_tree.model.view.View;
import family_tree.model.writer.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }

}
