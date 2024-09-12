package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.Gender;
import ru.gb.family_tree.model.Human;
import ru.gb.family_tree.model.Service;
import ru.gb.family_tree.view.View;
import ru.gb.family_tree.writer.FileHandler;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        String fileName = "src/ru/gb/family_tree/writer/family_tree.txt";  // Указываем путь к файлу
        this.service = new Service(new FileHandler(fileName));  // Передаем FileHandler в Service
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate, LocalDate deadDate, Human mother, Human father, List<Human> children) {
        service.addHuman(name, gender, birthDate, deadDate, mother, father, children);
        String fileName = "src/ru/gb/family_tree/writer/family_tree.txt";  // Путь к файлу
        service.saveFamilyTree(fileName);  // Передаем путь к файлу
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
