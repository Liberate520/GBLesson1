package family_tree.model.view;

import family_tree.model.human.Gender;
import family_tree.model.presenter.Presenter;
import family_tree.model.view.commads.TreeMenu;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private  boolean flag;
    private TreeMenu menu;

    public ConsoleUI() {
        presenter = new Presenter((View) this);
        scanner = new Scanner(System.in);
        menu = new TreeMenu(this);
        flag = true;
    }

    @Override
    public void start() {
        while (flag) {
            System.out.println("Select action");
            System.out.println(menu.menu());
            String act = scanner.nextLine();
            int actInt = Integer.parseInt(act);
            if (actInt >= 0) {
                menu.execute(actInt);
            }
        }
    }

    public void addHuman() {
        System.out.println("Input name");
        String name = scanner.nextLine();
        System.out.println("Input birthdate");
        LocalDate birthDate = inputDate();
        LocalDate deathDate = null;
        System.out.println("Do you know death date?");
        boolean yesorno = inputYesOrNo();
        if(yesorno) {
            System.out.println("Input death date");
            deathDate = inputDate();
        }
        System.out.println("Input gender (Female, Male):");
        Gender gender = inputGender();
        presenter.addHuman(name, birthDate, deathDate, gender);
    }

    public LocalDate inputDate () {
        boolean inputDate;
        LocalDate requiredDate = null;
        do {
            System.out.println("input year:");
            String year = scanner.nextLine();
            System.out.println("input month:");
            String month = scanner.nextLine();
            System.out.println("input day:");
            String day = scanner.nextLine();
            String date = year + "-" + month + "-" + day;
            inputDate = true;
            try {
                requiredDate = LocalDate.parse(date);
            } catch (DateTimeParseException e) {
                inputDate = false;
                System.out.println("Wrong");
            }
        } while(!inputDate);
        return requiredDate;
    }

    public Gender inputGender() {
        boolean inputGender = true;
        Gender humanGender = null;
        do{
            String gender = scanner.nextLine();
            if(gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("f")) {
                humanGender = Gender.Female;
                inputGender = true;
            }
            else if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("m")){
                humanGender = Gender.Male;
                inputGender = true;
            } else {
                inputGender = false;
                System.out.println("Wrong\n" +
                        "Repeat");
            }
        } while (!inputGender);
        return humanGender;
    }

    public void addMother(){
        System.out.println("Input ID Mother");
        int motherID = scanner.nextInt();
        System.out.println("Input ID Child");
        int childID = scanner.nextInt();
        presenter.setMother(motherID, childID);
    }

    public void addFather(){
        System.out.println("Input ID Father");
        int fatherID = scanner.nextInt();
        System.out.println("Input ID Child");
        int childID = scanner.nextInt();
        presenter.setFather(fatherID, childID);
    }

    public void findHumanByID(){
        System.out.println("Input ID");
        int requiredID = scanner.nextInt();
        System.out.println(presenter.findByID(requiredID));
    }

    public void showParentName(){
        System.out.println("Input ID Child");
        int childID = scanner.nextInt();
        System.out.println(presenter.showParentName(childID));
    }

    public boolean inputYesOrNo(){
        boolean result = false;
        System.out.println("'y' - yes, 'n' - no");
        String choice = scanner.nextLine();
        switch (choice) {
            case "y" -> {
                result = true;
            }
            case "n" -> {
            }
        }
        return result;
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void showFamilyTree() {
        presenter.showFamilyTree();

    }
    public void finish() {
        flag = false;
    }

    public void saveFile() {
        System.out.println("Enter the full path and file name");
        String filePath = scanner.nextLine();
        if(!presenter.saveFile(filePath)) {
            System.out.println("The object cannot be saved");
            System.out.println("Enter the correct path");
        }
    }

    public void loadFile() {
        System.out.println("Enter the full path and file name");
        String filePath = scanner.nextLine();
        if (!presenter.loadFile(filePath)) {
            System.out.println("The object cannot be loaded");
            System.out.println("Enter the correct path");
        } else {
            presenter.showFamilyTree();
        }
    }

    public void printText(String text) {
        System.out.println(text);
    }

}
