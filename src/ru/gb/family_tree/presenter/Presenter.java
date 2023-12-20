package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addElement(String name, String birthPlace, Gender gender, LocalDate birthDate, int momID, int dadID) {
        service.addHuman(name, birthPlace, gender, birthDate, momID, dadID);
    }

    public void addElement(String name, String birthPlace, Gender gender, LocalDate birthDate, int parent) {
        service.addHuman(name, birthPlace, gender, birthDate, parent);
    }

    public void addElement(String name, String birthPlace, Gender gender, LocalDate birthDate) {
        service.addHuman(name, birthPlace, gender, birthDate);
    }

    public void getHumansList() {
        view.printAnswer(service.getHumansList());
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sortByAge() {
        service.sortByAge();
    }

    public boolean save(String path) {
        return service.save(path);
    }

    public void load(String file) {
        service.load(file);
    }

    public void setDeathDate(int iD, LocalDate date) {
        service.setDeathDate(iD, date);
    }

    public void addChildTo(int parentID, int childID) {
        service.addChildToHuman(parentID, childID);
    }
}
