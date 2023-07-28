package ru.gb.family_tree.viewer;

import ru.gb.family_tree.model.tree_elements.Item;
import ru.gb.family_tree.presenter.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseTerminal implements View {

    private Controller<Item> controller;
    private List<String> commands;
    private Scanner scanner;

    public BaseTerminal() {
        this.commands = new ArrayList<>();
        this.controller = new Controller<>();
        this.commands = createCommands();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void start() {
        while (true) {
            menu();
            int command = command(scanner);
            if ((command <= commands.size()) && (command > 0)) {
                controller.doCommand(commands.get(command - 1));
            } else if (command == 0) {
                System.out.println("Выход из меню.");
                break;
            } else {
                System.out.println("Некорректная команда, попробуйте ещё раз.");
            }
        }
    }

    private void menu() {
        System.out.println("--------------------------------------------");
        System.out.println("Введите команду:");
        createMenu();
        System.out.println("0 - Выход");
        System.out.println("--------------------------------------------");
    }

    private static int command(Scanner scanner) {
        int command;
        while (true) {
            if (scanner.hasNextInt()) {
                command = scanner.nextInt();
                break;
            } else {
                System.out.println("Некорректное значение, необходимо ввести число!");
                scanner.next();
            }
        }
        return command;
    }

    private void createMenu() {
        for (int i = 0; i < commands.size(); i++) {
            System.out.println((i+1) + " - " + commands.get(i));
        }
    }

    private List<String> createCommands() {
        List<String> list = new ArrayList<>();
        list.addAll(this.controller.getCommands().values());
        return list;
    }

}
