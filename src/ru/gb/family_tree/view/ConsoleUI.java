package ru.gb.family_tree.view;

import ru.gb.family_tree.model.Gender;
import ru.gb.family_tree.model.Human;
import ru.gb.family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Приветствие!");
        while (work) {
            System.out.println(menu.menu());
            String strChoice = scanner.nextLine();
            //метод проверки на валидность
            int choice = Integer.parseInt(strChoice);
            menu.execute(choice);
        }
    }

    public void finish() {
        System.out.println("До новых встреч");
        work = false;
    }

    public void getHumanListInfo() {
        presenter.getHumanListInfo();
    }

    public void sortByBirthDay() {
        presenter.sortByBirthDay();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void addHuman() {
        System.out.println("Введите имя члена семьи: ");
        String name = scanner.nextLine();
        System.out.println("Введите пол члена семьи (male/female): ");
        Gender gender = Gender.valueOf(scanner.nextLine().trim().toUpperCase());;
        System.out.println("Введите дату рождения члена семьи (в формате 'yyyy-mm-dd'): ");
        String strBirth = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(strBirth);
        System.out.println("Введите дату смерти члена семьи (в формате 'yyyy-mm-dd'): ");
        String strDead = scanner.nextLine();
        LocalDate deadDate = LocalDate.parse(strDead);
        System.out.println("Введите имя Мамы: ");
        String mother = scanner.nextLine();
        Human motherN = getHumanByName(mother);
        System.out.println("Введите имя Папы: ");
        String father = scanner.nextLine();
        Human fatherN = getHumanByName(father);
        System.out.println("Введите имя ребенка(детей): ");
        String children = scanner.nextLine();
        String childrenNames = scanner.nextLine();
        List<Human> childrenN = new ArrayList<>();
        if (!childrenNames.isEmpty()) {
            for (String childName : childrenNames.split(",")) {
                Human child = getHumanByName(childName.trim());
                if (child != null) {
                    childrenN.add(child);
                }
            }

            presenter.addHuman(name, gender, birthDate, deadDate, motherN, fatherN, childrenN);
        }
    }

    private Human getHumanByName(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        List<Human> humans = presenter.getByName(name);
        return humans.isEmpty() ? null : humans.get(0);
    }

    public void error() {
        System.out.println("Неверно введены данные");
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
