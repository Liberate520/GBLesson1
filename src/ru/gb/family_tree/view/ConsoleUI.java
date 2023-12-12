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

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }

    @Override
    public void start() {
        fl = true;
        System.out.println("Программа по созданию семейного дерева");
        while (fl) {
            System.out.println("1. Добавить элемент в семейное дерево");
            System.out.println("2. Получить список элементов семейного дерева");
            System.out.println("3. Добавить ребенка к элементу семейного дерева");
            System.out.println("4. Отсортировать семейное дерево по имени");
            System.out.println("5. Отсортировать семейное дерево по возрасту");
            System.out.println("6. Сохранить семейное дерево");
            System.out.println("7. Загрузить семейное дерево");
            System.out.println("8. Выход");
            String choice = scanner.nextLine();
            switch (choice) {
                case ("1"): {
                    addElement();
                    break;
                }
                case ("2"): {
                    getHumansList();
                    break;
                }
                case ("3"): {
                    addChildTo();
                    break;
                }
                case ("4"): {
                    sortByName();
                    break;
                }
                case ("5"): {
                    sortByAge();
                    break;
                }
                case ("6"): {
                    save();
                    break;
                }
                case ("7"): {
                    load();
                    break;
                }
                case ("8"): {
                    exit();
                    break;
                }
            }
        }

    }

    private void addChildTo() {
        getHumansList();
        System.out.println("Укажите ID элемента, которому необходимо добавить ребенка: ");
        int parentID = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите ID ребенка: ");
        int childID = Integer.parseInt(scanner.nextLine());
        presenter.addChildTo(parentID, childID);
    }

    private void load() {
        System.out.println("Укажите путь к файлу и файл для загрузки (Пример - 'D:\\Save\\tree.out)': ");
        String file = scanner.nextLine();
        presenter.load("src/ru/gb/family_tree/model/storage/Tree.out");
    }

    private void save() {
        System.out.println("Укажите место для сохранения файла (Пример - 'D:\\Save)': ");
        String path = scanner.nextLine();
        presenter.save("src/ru/gb/family_tree/model/storage/Tree.out");
    }

    private void sortByAge() {
        presenter.sortByAge();
    }

    private void sortByName() {
        presenter.sortByName();
    }

    private void getHumansList() {
        presenter.getHumansList();
    }

    private void exit() {
        System.out.println("До свидания");
        fl = false;
    }

    private void addElement() {
        getHumansList();
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
            getHumansList();
            int momID = Integer.parseInt(scanner.nextLine());
            System.out.println("Вам известен ID отца (Да \\ Нет) ");
            String dad = scanner.nextLine().toLowerCase();
            if (dad.equals("да")) {
                System.out.println("Введите ID отца: ");
                getHumansList();
                int dadID = Integer.parseInt(scanner.nextLine());
                presenter.addElement(name, birthPlace, gender, birthDate, momID, dadID);
            } else presenter.addElement(name, birthPlace, gender, birthDate, momID);
        } else {
            System.out.println("Вам известен ID отца (Да \\ Нет) ");
            String dad = scanner.nextLine().toLowerCase();
            if (dad.equals("да")) {
                getHumansList();
                System.out.println("Введите ID отца: ");
                int dadID = Integer.parseInt(scanner.nextLine());
                presenter.addElement(name, birthPlace, gender, birthDate, dadID);
            } else {
                presenter.addElement(name, birthPlace, gender, birthDate);
            }
        }
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
