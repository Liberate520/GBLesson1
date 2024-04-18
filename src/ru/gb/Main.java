package ru.gb;

import ru.gb.family_tree.FamilyTree;
import ru.gb.human.Gender;
import ru.gb.human.Human;
import ru.gb.writer.FileHandler;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/family_tree/writer/tree.txt";

        FamilyTree tree = testTree();
        System.out.println(tree);
        
        save(tree, filePath);
    }
    
    static FamilyTree read(String filePath) {
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read(filePath);
    }
    
    static void save(FamilyTree familyTree, String filePath) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree, filePath);
    }

    static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();

        Human ivan = new Human("Ivan", Gender.Male, LocalDate.of(1975, 4, 13));
        Human sveta = new Human("Svetlana", Gender.Female, LocalDate.of(1989, 12, 25));
        tree.add(ivan);
        tree.add(sveta);

        return tree;
    }
}

