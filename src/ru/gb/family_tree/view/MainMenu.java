package ru.gb.family_tree.view;

import ru.gb.family_tree.model.Gender;
import ru.gb.family_tree.model.Person;
import ru.gb.family_tree.presenter.SavingType;
/*
Выполняется принцип "L" В конструкторе приходит параметр типа View, который более общий, чем класс ConsoleUI.
 */
public class MainMenu {

    private View UI;

    public MainMenu(View UI) {
        this.UI = UI;
    }

    public void start(int choice) {

        switch (choice) {
            case 1:
                UI.print("Введите имя");
                String name = UI.read();
                UI.print("Введите пол. Если женский то Ж, если мужской то Ж");
                String sGender = UI.read();
                Gender gender;
                if (sGender.equals("M"))
                    gender = Gender.MALE;
                else
                    gender = Gender.FEMALE;
                Person person = new Person(name, gender);
                UI.addFamilyTreeMember(person);
                UI.printf("Член семейного дерева %s добавлен\n", name);
                break;
            case 2:
                UI.print("Семейное дерево:");
                UI.getFamilyTreeInfo();
                break;
            case 3:
                UI.sortByName();
                UI.print("Успешно отсортировано по имени");

                break;
            case 4:
                UI.sortByAge();
                UI.print("Успешно отсортировано по возрасту");
                break;
            case 5:
                UI.save(SavingType.FILE);
                UI.print("Сохранить в файл");
                break;
            case 6:
                UI.load(SavingType.FILE);
                UI.print("Загрузить из файла");
                break;
            case 7:
                UI.finish();
                break;
            default:
                UI.print("ошибка");

        }

    }
}
