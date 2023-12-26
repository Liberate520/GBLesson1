package ru.gb.family_tree.view;

import ru.gb.family_tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

/*
Выполняется принцип "L" В конструкторе приходит параметр типа View, который более общий, чем класс ConsoleUI.
 */
public class MainMenu {

    private View UI;
    private List<Command> commandList;

    public MainMenu(View UI) {
        this.UI = UI;
    }

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddPerson(consoleUI));
        commandList.add(new GetInfo(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();


    }
    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }

//    public void start(int choice) {
//
//        switch (choice) {
//            case 1:
//                UI.print("Введите имя");
//                String name = UI.read();
//                UI.print("Введите пол. Если женский то Ж, если мужской то Ж");
//                String sGender = UI.read();
//                Gender gender;
//                if (sGender.equals("M"))
//                    gender = Gender.MALE;
//                else
//                    gender = Gender.FEMALE;
//                Person person = new Person(name, gender);
//                UI.addFamilyTreeMember(person);
//                UI.printf("Член семейного дерева %s добавлен\n", name);
//                break;
//            case 2:
//                UI.print("Семейное дерево:");
//                UI.getFamilyTreeInfo();
//                break;
//            case 3:
//                UI.sortByName();
//                UI.print("Успешно отсортировано по имени");
//
//                break;
//            case 4:
//                UI.sortByAge();
//                UI.print("Успешно отсортировано по возрасту");
//                break;
//            case 5:
//                UI.save(SavingType.FILE);
//                UI.print("Сохранить в файл");
//                break;
//            case 6:
//                UI.load(SavingType.FILE);
//                UI.print("Загрузить из файла");
//                break;
//            case 7:
//                UI.finish();
//                break;
//            default:
//                UI.print("ошибка");
//
//        }
//
//    }
}
