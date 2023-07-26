package ru.gb.family_tree.viewer.commands;

import ru.gb.family_tree.model.tree.FamilyTree;
import ru.gb.family_tree.model.tree_elements.Fundamental;
import ru.gb.family_tree.model.tree_elements.Gender;
import ru.gb.family_tree.model.tree_elements.Item;
import ru.gb.family_tree.service.handler.Writable;
import ru.gb.family_tree.service.tree_service.TreeService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class CommandsService<E extends Fundamental<E>> implements CommandsFunction {
    private TreeService<E> treeService;
    private Scanner scanner;
    private DateTimeFormatter formatter;
    private Writable writable;

    private HashMap<Commands, String> commands; //для новой версии терминала необходимо обновить список либо сделать новый

    public CommandsService(Writable writable) {
        this.writable = writable;
        this.commands =new HashMap<>();
        createCommands();
        this.treeService = new TreeService<E>(new FamilyTree<E>());
        this.scanner = new Scanner(System.in);
        this.formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    }

    @Override
    public void createCommands() {
        commands.put(Commands.NEW_TREE, "Активировать новое дерево");
        commands.put(Commands.ADD_ITEM, "Добавить элемент дерева");
        commands.put(Commands.REMOVE_ITEM, "Удалить элемент дерева");
        commands.put(Commands.ADD_PARENTS, "Добавить родителей");
        commands.put(Commands.GET_PARENTS, "Показать родителей");
        commands.put(Commands.ADD_CHILDREN, "Добавить детей");
        commands.put(Commands.GET_CHILDREN, "Показать детей");
        commands.put(Commands.ADD_SPOUSE, "Добавить супруга (пару)");
        commands.put(Commands.REMOVE_SPOUSE, "Прервать отношение пары");
        commands.put(Commands.GET_ELEMENT, "Показать элемент дерева");
        commands.put(Commands.GET_TREE, "Показать все элементы дерева");
        commands.put(Commands.SAVE, "Сохранить изменения");
        commands.put(Commands.LOAD, "Загрузить последние сохраненные изменения");
    }

    public HashMap<Commands, String> getCommands() {
        return commands;
    }

    @Override
    public Commands chooseCommand(String line) {
        Optional<Commands> result = commands.entrySet()
                .stream()
                .filter(entry -> line.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();
        Commands commands = result.orElse(null);
        return commands;
    }

    @Override
    public void doCommand(String line) {
        Commands commands = chooseCommand(line);
        switch (commands) {
            case NEW_TREE:
                newTree();
                break;
            case ADD_ITEM:
                addItem();
                break;
            case REMOVE_ITEM:
            case ADD_PARENTS:
            case GET_PARENTS:
            case ADD_CHILDREN:
            case GET_CHILDREN:
            case ADD_SPOUSE:
            case REMOVE_SPOUSE:
            case GET_ELEMENT:
            case GET_TREE:
                getTree();
                break;
            case SAVE:
                save();
                break;
            case LOAD:
                load();
                break;
            default:
                System.out.println("Команда не найдена");
        }
    }

    private void newTree() {
        treeService = new TreeService<E>(new FamilyTree<>());
        System.out.println("Информация по семейному дереву очищена");
    }

    private void addItem() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию:");
        String surname = scanner.nextLine();
        System.out.println("Укажите дату рождения в формате dd.MM.yyyy:");
        LocalDate birthday = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.println("Нажмите 1, если пол мужской, 2 - если пол женский:");
        int i = scanner.nextInt();
        Gender gender = null;
        if (i == 1) {
            gender = Gender.Male;
        } else if (i == 2) {
            gender = Gender.Female;
        }
        Item item = new Item(name, surname, birthday, gender);
        treeService.addElement((E)item);
    }

    private void getTree() {
        System.out.println("В дереве имеются следующие элементы: ");
        this.treeService.SortByName().forEach(System.out::println);
    }

    void save() {
        writable.save(treeService.getFamilyTree());
        System.out.println("Данные сохранены");
    }

    void load() {
        treeService.setFamilyTree(writable.read());
        System.out.println("Данные загружены");
    }
}
