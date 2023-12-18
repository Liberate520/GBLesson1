package ru.gb.family_tree.view;

import ru.gb.family_tree.presenter.PresenterService;

import java.util.Scanner;

public class ConsoleUI implements View {

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private final Scanner scanner;
    private boolean work;
    private static int N = 0;
    private PresenterService presenter;


    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new PresenterService(this);
        work = true;

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
                presenter.start(numCommand);
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
        System.out.printf("%d. Закончить работу\n", ++N);
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);
    }
}
