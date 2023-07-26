package ru.gb.family_tree.viewer;

import ru.gb.family_tree.model.tree_elements.Item;
import ru.gb.family_tree.service.handler.Writable;
import ru.gb.family_tree.service.tree_service.TreeService;
import ru.gb.family_tree.viewer.commands.CommandsService;

import java.util.Scanner;

public class BaseTerminal<E extends TreeService> implements Vew {

    private CommandsService<Item> commandsService;
    private Scanner scanner;

    public BaseTerminal(Writable writable) {
        this.commandsService = new CommandsService<>(writable);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void start() {
        while (true) {
            menu();
            int command = command(scanner);
            if (command == 1) {
                commandsService.doCommand("Активировать новое дерево");
            } else if (command == 2) {
                commandsService.doCommand("Добавить элемент дерева");
            } else if (command == 3) {
                commandsService.doCommand("Показать все элементы дерева");
            } else if (command == 4) {
                commandsService.doCommand("Сохранить изменения");
            } else if (command == 5) {
                commandsService.doCommand("Загрузить последние сохраненные изменения");
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
        System.out.println("1 - Активировать новое дерево");
        System.out.println("2 - Добавить элемент дерева");
        System.out.println("3 - Показать все элементы дерева");
        System.out.println("4 - Сохранить изменения");
        System.out.println("5 - Загрузить последние сохраненные изменения");
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
}
