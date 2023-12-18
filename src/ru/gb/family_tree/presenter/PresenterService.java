package ru.gb.family_tree.presenter;

import ru.gb.family_tree.FamilyTree;
import ru.gb.family_tree.model.Gender;
import ru.gb.family_tree.model.Person;
import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.View;
import ru.gb.family_tree.writer.Writable;

import java.util.Scanner;

public class PresenterService {
    private FamilyTree<Person> familyTree = new FamilyTree<>();
    private Scanner scanner;

    View UI;

    public PresenterService(View UI) {
        this.UI = UI;
    }

    public void addFamilyTreeMember(Person person) {
        familyTree.addFamilyTreeMember(person);
    }

    public String getFamilyTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person : familyTree) {
            stringBuilder.append(person);
        }
        return stringBuilder.toString();
    }

    public void start(int choice) {
        //UI.start();
        // String choice = UI.read();
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
                addFamilyTreeMember(person);
                UI.printf("Член семейного дерева %s добавлен\n", name);
                break;
            case 2:
                String result = getFamilyTreeInfo();
                UI.print(result);
                break;
            case 3:
               sortByName();
               UI.print("Успешно отсортировано по имени");

                break;
            case 4:
                sortByAge();
                UI.print("Успешно отсортировано по возрасту");
                break;
            case 5:
                UI.finish();
                break;
            default:
                UI.print("ошибка");

        }

    }

    public void addParent(Person person, Person child) {
        familyTree.addParent(person, child);
    }


    public void save(Writable writable) {
        writable.save(familyTree);
    }

    public void load(Writable writable) {
        familyTree = (FamilyTree) writable.load();

    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }
}
