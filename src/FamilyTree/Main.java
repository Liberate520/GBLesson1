package FamilyTree;

import FamilyTree.HR.Human;
import FamilyTree.HR.Gender;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = myTree();
        System.out.println(tree);
    }

    static FamilyTree myTree(){
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
