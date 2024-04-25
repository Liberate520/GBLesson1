package ru.gb.study_group.View;

import ru.gb.study_group.Presenter.Presenter;

import javax.xml.transform.Source;
import java.util.Scanner;

public class Console implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean status;
    private MainMenu mainMenu;

    public Console() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        status = true;
        mainMenu = new MainMenu (this);
    }

    @Override
    public void start() {
        System.out.println("Выберите действие: ");

        while (status) {
            System.out.println(mainMenu.getMenu());
            String strChoice = scanner.nextLine();
            // check for validation input values
            int choice = Integer.parseInt(strChoice);
            mainMenu.execute(choice);
        }
    }

    public void finish() {
        status = false;
        System.out.println("До свидания.");
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
         presenter.sortByName();
    }

    public void getstudentListInfo() {
        presenter.getStudentsInfo();
    }

    public void addStudent() {
        System.out.println("Введите имя студента. ");
        String name = scanner.nextLine();

        System.out.println("Введите возраст студента. ");
        String sTrage = scanner.nextLine();
        int age = Integer.parseInt(sTrage);
        presenter.addStudent(name, age);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }
}
