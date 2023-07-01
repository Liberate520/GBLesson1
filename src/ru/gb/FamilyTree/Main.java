package GBLesson1.src.ru.gb.FamilyTree;

import GBLesson1.src.ru.gb.FamilyTree.Human.Gender;
import GBLesson1.src.ru.gb.FamilyTree.Human.Human;
import GBLesson1.src.ru.gb.FamilyTree.Human.MotFath;
import GBLesson1.src.ru.gb.FamilyTree.Tree.FamilyTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree famtree = new FamilyTree(1);
        List<String> kids = new ArrayList<>(Arrays.asList("Иван Поп", "Ева Поп"));
        Human human1 = new Human(Gender.Male, 26, "Стёпа", "Поп", MotFath.Father, kids);
        Human human2 = new Human(Gender.Female, 23, "Ольга", "Поп", MotFath.Mother, kids);
        Human human3 = new Human(Gender.Male, 12, "Стёпа", "Поп", MotFath.Father, null);
        Human human4 = new Human(Gender.Female, 10, "Ева", "Поп", MotFath.Child, null);
        famtree.addHuman(human1);
        famtree.addHuman(human2);
        famtree.addHuman(human3);
        famtree.addHuman(human4);
        System.out.println(famtree.getHumanInfo());
    }
}


