package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.HumanFactory;
import ru.gb.family_tree.model.PersonFactory;
import ru.gb.family_tree.model.Service;
import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.save.FileHandler;
import ru.gb.family_tree.model.save.Writable;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service<Human> service;
    private PersonFactory<Human> factory;

    public Presenter(View view) {
        this.view = view;
        factory =  new HumanFactory();
        service = new Service<>(factory);
    }


    public void addHuman(String name, String gender, LocalDate date){
        service.addHuman(name, gender, date);
        getHumanInfo();
    }
    public void getHumanInfo(){
        view.printAnswer(service.getHumanInfo());
    }

    public void sortByName() {
        service.sotrByName();
        getHumanInfo();
    }

    public void saveFemaleTree() {
        service.saveFemaleTree();
    }

    public void loadFemaleTree() {
        service.loadFemaleTree();
    }

    public void setWedding(int idMale, int idFemale) {
        service.setWedding(idMale, idFemale);
        getHumanInfo();
    }

    public void addChildren(int idParent, int idChild) {
        service.addChildren(idParent, idChild);
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        getHumanInfo();
    }
}
