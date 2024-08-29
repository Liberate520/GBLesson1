package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.Gender;
import ru.gb.family_tree.model.Human;
import ru.gb.family_tree.model.Service;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        this.service = new Service();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate, LocalDate deadDate, Human mother, Human father, List<Human> children) {
        service.addHuman(name, gender, birthDate, deadDate, mother, father, children);
        service.saveFamilyTree("src/ru/gb/family_tree/writer/family_tree.txt");
        getHumanListInfo();
    }

    public void sortByName() {
        service.sortByName();
        getHumanListInfo();
    }

    public void sortByBirthDay() {
        service.sortByBirthDay();
        getHumanListInfo();
    }

    public void getHumanListInfo() {
        String answer = service.getHumanListInfo();
        view.printAnswer(answer);
    }

    public List<Human> getByName(String name) {
        return service.getByName(name);
    }
}
