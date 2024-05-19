package HumanTree_by_Krito;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        Human Irina = new Human("Ирина", Gender.Female, LocalDate.of(1988, 6, 12));
        Human Anatoly = new Human("Анатолий", Gender.Male, LocalDate.of(1987, 8, 22));

        tree.add(Irina);
        tree.add(Anatoly);


        System.out.println(tree);
    }
}
