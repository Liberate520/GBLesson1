package ru.gb.family_tree.view;

import ru.gb.family_tree.model.Person;
import ru.gb.family_tree.presenter.Presenter;
import ru.gb.family_tree.presenter.SavingType;
import java.util.Scanner;
/*
Выполняется принцип "О" - принцип открытости - закрытости. Можно бесконечно расширять функционал класса.
Нарушается в методе "printMenu"
 */

public class ConsoleUI implements View {

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private final Scanner scanner;
    private boolean work;
    private static int N = 0;
    private Presenter presenter;
    private MainMenu menu;


    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);

    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void printf(String text, String placeHolder) {
        System.out.printf(text, placeHolder);
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }

    @Override
    public void start() {
        hello();
        while (work) {
            printMenu();
            execute();
        }
    }

    @Override
    public void finish() {
        System.out.println("Приятно было пообщаться");
        work = false;
    }

    private void hello() {
        System.out.println("Доброго времени суток!");
    }

    private void execute() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)) {
                menu.start(numCommand);
            }
        }

    }

    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand <= N) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu() {
        N = 0;
        System.out.printf("%d. Добавить члена семьи \n", ++N);
        System.out.printf("%d. Вывести информацию о семейном дереве\n", ++N);
        System.out.printf("%d. Сортировать членов семейного дерева по имени\n", ++N);
        System.out.printf("%d. Сортировать членов семейного дерева по возрасту\n", ++N);
        System.out.printf("%d. Сохранить в файл]\n", ++N);
        System.out.printf("%d. Загрузить из файла\n", ++N);
        System.out.printf("%d. Закончить работу\n", ++N);
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);
    }

    @Override
    public void addFamilyTreeMember(Person person) {
        presenter.addFamilyTreeMember(person);
    }

    @Override
    public void getFamilyTreeInfo() {
        presenter.getFamilyTreeInfo();

    }

    @Override
    public void sortByName() {
        presenter.sortByName();

    }

    @Override
    public void sortByAge() {
        presenter.sortByAge();
    }

    @Override
    public void save (SavingType savingType) {
        presenter.save(savingType);
    }

    @Override
    public void load(SavingType savingType) {
        presenter.load(savingType);
    }
}
