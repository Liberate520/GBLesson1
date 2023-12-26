package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.model.writer.FileHandler;
import ru.gb.family_tree.view.View;

public class Presenter {
    private View UI;
    private Service service;


    public Presenter(View UI) {

        this.UI = UI;
        this.service = new Service();
    }

    public void addFamilyTreeMember(String name, String sGender) {
        service.addFamilyTreeMember(name, sGender);

    }

    public void getFamilyTreeInfo() {
        String info = service.getFamilyTreeInfo();
        UI.print(info);
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sortByAge() {
        service.sortByAge();

    }

    public void saveToFile() {
        service.save(new FileHandler());
    }

    public void loadFromFile() {
        service.load(new FileHandler());
    }
}
