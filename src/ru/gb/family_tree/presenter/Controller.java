package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.handler.FileHandler;
import ru.gb.family_tree.model.tree.FamilyTree;
import ru.gb.family_tree.model.tree_elements.Fundamental;
import ru.gb.family_tree.model.tree_elements.Gender;
import ru.gb.family_tree.model.tree_elements.Item;
import ru.gb.family_tree.model.handler.Writable;
import ru.gb.family_tree.model.tree.tree_service.TreeService;
import ru.gb.family_tree.presenter.commands.Commands;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Controller<E extends Fundamental<E>> implements Functions {
    private TreeService<E> treeService;
    private Scanner scanner;
    private DateTimeFormatter formatter;
    private Writable writable;

    private HashMap<Commands, String> commands; //для новой версии терминала необходимо обновить список либо сделать новый

    public Controller() {
        this.writable = new FileHandler("data.txt");
        this.commands =new HashMap<>();
        createCommands();
        this.treeService = new TreeService<>(new FamilyTree<E>());
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
                .findFirst();7
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
                removeItem();
                break;
            case ADD_PARENTS:
                addParents();
                break;
            case GET_PARENTS:
                getParents();
                break;
            case ADD_CHILDREN:
                addChildren();
                break;
            case GET_CHILDREN:
                getChildren();
                break;
            case ADD_SPOUSE:
                addSpouse();
                break;
            case REMOVE_SPOUSE:
                removeSpouse();
                break;
            case GET_ELEMENT:
                getItem();
                break;
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

    private void getItem() {
        System.out.println("Введите ID элемента дерева, информацию по которому хотите получить: ");
        int id = scanner.nextInt();
        System.out.println(treeService.getElement(id));
    }

    private void getTree() {
        System.out.println("В дереве имеются следующие элементы: ");
        this.treeService.SortByBirthday().forEach(System.out::println);
    }

    private void save() {
        writable.save(treeService.getFamilyTree());
        System.out.println("Данные сохранены");
    }

    private void load() {
        treeService.setFamilyTree(writable.read());
        System.out.println("Данные загружены");
    }

    private void addParents() {
        System.out.println("Введите ID элемента дерева, которому добавляются родители: ");
        int id1 = scanner.nextInt();
        System.out.println("Введите ID первого родителя: ");
        int id2  = scanner.nextInt();
        E parents1 = treeService.getElement(id2);
        System.out.println("Введите ID второго родителя: ");
        int id3 = scanner.nextInt();
        E parents2 = treeService.getElement(id3);
        List<E> parents = new ArrayList<>();
        parents.add(parents1);
        parents.add(parents2);
        treeService.addParents(id1, parents);
    }

    private void removeItem() {
        System.out.println("Введите ID элемента дерева, которой хотите удалить: ");
        int id = scanner.nextInt();
        treeService.removeItem(id);
    }

    private void getParents() {
        System.out.println("Введите ID элемента дерева, родителей которого хотите посмотреть: ");
        int id = scanner.nextInt();
        treeService.getParents(id).forEach(System.out::println);
    }

    private void addChildren() {
        System.out.println("Введите ID элемента дерева, которому добавляется ребенок: ");
        int id1 = scanner.nextInt();
        System.out.println("Введите ID ребенка: ");
        int id2  = scanner.nextInt();
        E child = treeService.getElement(id2);
        List<E> children = new ArrayList<>();
        children.add(child);
        treeService.addChildren(id1, children);
    }

    private void getChildren() {
        System.out.println("Введите ID элемента дерева, детей которого хотите посмотреть: ");
        int id = scanner.nextInt();
        treeService.getChildren(id).forEach(System.out::println);
    }

    private void addSpouse() {
        System.out.println("Введите ID супруга: ");
        int id1 = scanner.nextInt();
        System.out.println("Введите ID супруги: ");
        int id2 = scanner.nextInt();
        treeService.addSpouse(id1, id2);
    }

    private void removeSpouse() {
        System.out.println("Введите ID супруга, отношения которого расторгаются: ");
        int id = scanner.nextInt();
        treeService.removeSpouse(id);
    }
}
