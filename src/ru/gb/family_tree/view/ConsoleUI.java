package ru.gb.family_tree.view;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    boolean fl;
    Gender gender;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        fl = true;
        System.out.println("Программа по созданию семейного дерева");
        while (fl) {
            System.out.println(menu.menuElements());
            String choice = scanner.nextLine();
            //метод для проверки количества элементов в списке
            int correctChoice = Integer.parseInt(choice);
            menu.action(correctChoice);
        }

    }

    public void addChildTo() {
        getElementsList();
        System.out.println("Укажите ID элемента, которому необходимо добавить ребенка: ");
        int parentID = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите ID ребенка: ");
        int childID = Integer.parseInt(scanner.nextLine());
        presenter.addChildTo(parentID, childID);
    }

    public void load() {
        System.out.println("Укажите путь к файлу и файл для загрузки (Пример - 'D:\\Save\\tree.out)': ");
        String file = scanner.nextLine();
        presenter.load("src/ru/gb/family_tree/model/storage/Tree.out");
    }

    public void save() {
        System.out.println("Укажите место для сохранения файла (Пример - 'D:\\Save)': ");
        String path = scanner.nextLine();
        if (path.isEmpty()){
            if(presenter.save("src/ru/gb/family_tree/model/storage/Tree.out")){
                System.out.println("Сохранено как: \"src/ru/gb/family_tree/model/storage/Tree.out\"\n");
            }
            else {
                System.out.println("Что-то пошло не так.\n");
            }
        }
        else {
            if(presenter.save(path)){
                System.out.println("Сохранено как: " + path);
            }
            else {
                System.out.println("Что-то пошло не так.");
            }
        }

    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getElementsList() {
        presenter.getHumansList();
    }

    public void exit() {
        System.out.println("До свидания");
        fl = false;
    }

    public void addElement() {
        getElementsList();
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        boolean gen = true;
        while (gen) {
            System.out.println("Укажите пол (М \\ Ж): ");
            String g = scanner.nextLine().toLowerCase();
            if (g.equals("м") || g.equals("ж")) {
                if (g.equals("м")) {
                    gender = Gender.Male;
                } else {
                    gender = Gender.Female;
                }
                gen = false;
            }
        }
        System.out.println("Введите дату рождения: ");
        System.out.println("День: ");
        int day = Integer.parseInt(scanner.nextLine());
        System.out.println("Месяц: ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Год: ");
        int year = Integer.parseInt(scanner.nextLine());
        LocalDate birthDate = LocalDate.of(year, month, day);
        System.out.println("Укажите место рождения: ");
        String birthPlace = scanner.nextLine();
        System.out.println("Вам известен ID матери (Да \\ Нет) ");
        String mom = scanner.nextLine().toLowerCase();
        if (mom.equals("да")) {
            System.out.println("Введите ID матери: ");
            getElementsList();
            int momID = Integer.parseInt(scanner.nextLine());
            System.out.println("Вам известен ID отца (Да \\ Нет) ");
            String dad = scanner.nextLine().toLowerCase();
            if (dad.equals("да")) {
                System.out.println("Введите ID отца: ");
                getElementsList();
                int dadID = Integer.parseInt(scanner.nextLine());
                presenter.addElement(name, birthPlace, gender, birthDate, momID, dadID);
            } else presenter.addElement(name, birthPlace, gender, birthDate, momID);
        } else {
            System.out.println("Вам известен ID отца (Да \\ Нет) ");
            String dad = scanner.nextLine().toLowerCase();
            if (dad.equals("да")) {
                getElementsList();
                System.out.println("Введите ID отца: ");
                int dadID = Integer.parseInt(scanner.nextLine());
                presenter.addElement(name, birthPlace, gender, birthDate, dadID);
            } else {
                presenter.addElement(name, birthPlace, gender, birthDate);
            }
        }
    }

    public void setDeathDate() {
        getElementsList();
        System.out.println("Укажите ID покойника: ");
        int iD = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите дату смерти: ");
        System.out.println("День: ");
        int day = Integer.parseInt(scanner.nextLine());
        System.out.println("Месяц: ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Год: ");
        int year = Integer.parseInt(scanner.nextLine());
        LocalDate deathDate = LocalDate.of(year, month, day);
        presenter.setDeathDate(iD, deathDate);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
