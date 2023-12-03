package FamilyTree;

import FamilyTree.HR.Gender;
import FamilyTree.HR.Human;
import FamilyTree.writer.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        FamilyTree tree = upTree();

//        FamilyTree tree = load();
        System.out.println(tree);
        save(tree);
    }

    private static FamilyTree load() {
        String filePath = "src/FamilyTree/writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read(filePath);
    }

    private static void save(FamilyTree tree) {
        String filePath = "src/FamilyTree/writer/tree.txt";
        FileHandler fileHandler = new FileHandler();
        if (fileHandler.save(tree, filePath)) {
            System.out.println("каталог сохранён");
        }
        else {
            System.out.println("проверьте параметры сохранения");
        }
    }

    static FamilyTree upTree(){
        FamilyTree tree = new FamilyTree();

        Human polina = new Human("Полина", Gender.Female, LocalDate.of(1936, 9 ,16), LocalDate.of(1997, 5, 2));
        tree.add(polina);

        Human Viktor = new Human("Виктор", Gender.Male, LocalDate.of(1967, 4, 9), null, polina);
        Human Vika = new Human("Виктория", Gender.Female, LocalDate.of(1969, 9, 7));
        tree.add(Viktor);
        tree.add(Vika);

        Human Olga = new Human("Ольга", Gender.Female, LocalDate.of(1990, 2, 14), Viktor, Vika);
        tree.add(Olga);
        Human igor = new Human("Игорь", Gender.Male, LocalDate.of(2018, 8, 14), Olga);
        tree.add(igor);


        return tree;
    }
}
