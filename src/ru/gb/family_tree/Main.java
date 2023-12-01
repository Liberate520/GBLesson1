package ru.gb.family_tree;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        FamilyTree tree = createTree();
//        System.out.println(tree);
//        save(tree);
        FamilyTree tree = load();
        System.out.println(tree);
    }

    private static void save(FamilyTree tree) {
        String path = "src/ru/gb/family_tree/tree.out";
        FileHodler fh = new FileHodler();
        fh.save(tree, path);
    }

    private static FamilyTree load() {
        String path = "src/ru/gb/family_tree/tree.out";
        FileHodler fh = new FileHodler();
        return (FamilyTree) fh.load(path);
    }

    static FamilyTree createTree() {
        FamilyTree tree = new FamilyTree();

        Human me = new Human("Denis", "Krasnodar", Gender.Male, LocalDate.of(1987, 07, 07));

        Human wife = new Human("Jane", "Murmansk", Gender.Female, LocalDate.of(1991, 05, 05));

        Human daughter = new Human("Alice", "Sochi", Gender.Female, LocalDate.of(2016, 12, 12), wife, me);
        tree.add(me);
        tree.add(wife);
        tree.add(daughter);
        Human mom = new Human("Nataly", "Ural", Gender.Female, LocalDate.of(1965, 02, 02));
        tree.add(mom);
        mom.addChild(me);
        return tree;
    }


}



