package ru.gb.family_list.view;

import ru.gb.family_list.model.human.Human;
import ru.gb.family_list.presenter.Presenter;
import ru.gb.family_list.view.commands.CommandsList;
import ru.gb.family_list.writer.FileHandlerList;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ConsoleUi implements View{

   private Scanner scanner;
   private Presenter presenter;
   private boolean status;
   private CommandsList cl;

    public ConsoleUi() {
            scanner = new Scanner(System.in);
            presenter = new Presenter(this);
            status = true;
            cl = new CommandsList(this);
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        while (status) {
            printCommands();
            execute();
        }
    }

    private void execute() throws IOException, ClassNotFoundException {
        int commandNumber = Integer.parseInt(scanner.nextLine());
        if(commandNumber - 1 < cl.getCommands().size()){
            cl.execute(commandNumber - 1);
        } else {
            System.out.println("Incorrect value!");
        }
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getFullList() {
        presenter.getFullList();
    }

    public void save() {
        System.out.println("Print path");
        String path = scanner.nextLine();
        System.out.println("Print number of handler");
        printFileHandlers();
        String handler = scanner.nextLine();
        presenter.save(path, Integer.parseInt(handler));
    }

    public void read() {
        System.out.println("Print path");
        String path = scanner.nextLine();
        System.out.println("Print number of filetype");
        System.out.println(presenter.getStringHandlers());
        String filetype = scanner.nextLine();
        presenter.read(path, Integer.parseInt(filetype));
        presenter.getFullList();
    }

    public void addHuman() {
        System.out.println("Print name");
        String name = scanner.nextLine();
        System.out.println("Print surname");
        String surname = scanner.nextLine();
        System.out.println("Print day of birth");
        String daydob = scanner.nextLine();
        System.out.println("Print month of birth");
        String monthdob = scanner.nextLine();
        System.out.println("Print year of birth");
        String yeardob = scanner.nextLine();
        GregorianCalendar dob = new GregorianCalendar(Integer.parseInt(yeardob), Integer.parseInt(monthdob) - 1, Integer.parseInt(daydob));
        System.out.println("Print human gender 1 - MALE; 2-FEMALE; You can left this field empty");
        Human.Gender gender = convertGender(scanner.nextLine());
        System.out.println("Print index of mother (You can leave this field empty)");
        String momIndex = scanner.nextLine();
        System.out.println("Print index of father (You can leave this field empty)");
        String dadIndex = scanner.nextLine();
        presenter.addHuman(name, surname, dob, gender, !momIndex.isEmpty() ? Integer.parseInt(momIndex) : null, !dadIndex.isEmpty() ? Integer.parseInt(dadIndex) : null);
    }

    public void finish(){
        status = false;
        System.out.println("Goodbye!");
    }

    private Human.Gender convertGender(String string) {
        return switch (string) {
            case "1" -> Human.Gender.MALE;
            case "2" -> Human.Gender.FEMALE;
            default -> null;
        };
    }

    private void printCommands(){
        System.out.println(cl.getStringCommands());
    }

    private void printFileHandlers(){
        System.out.println(presenter.getStringHandlers());
    }

    private void printAvailableFIleTypes() {
        System.out.println(presenter.getAvailableFileTypes());
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }
}
