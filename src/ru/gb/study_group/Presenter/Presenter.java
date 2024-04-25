package ru.gb.study_group.Presenter;

import ru.gb.study_group.Model.Service.Service;
import ru.gb.study_group.View.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addStudent(String name, int age) {
        service.addStudent(name,age);
        getStudentsInfo();
    }

    public void getStudentsInfo() {
        String studentsInfo = service.getStudentsInfo();
        view.printAnswer(studentsInfo);
    }


    public void sortByName() {
        service.sortByName();
        getStudentsInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getStudentsInfo();
    }
}
