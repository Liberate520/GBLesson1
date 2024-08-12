package ru.gb.family_tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human human1 = new Human(0, "Вероника", Gender.female, LocalDate.of(2022, 5, 24), null, Arrays.asList(human4, human5), Arrays.asList(null));
        Human human2 = new Human(1, "Лука", Gender.male, LocalDate.of(2016, 6, 19), null, List<Human> parents, List<Human> children);
        Human human3 = new Human(2, "Никмта", Gender.male, LocalDate.of(2009, 11, 23), null, List<Human> parents, List<Human> children);
        Human human4 = new Human(3, "Мария", Gender.female, LocalDate.of(1990, 8, 17), null, List<Human> parents, List<Human> children);
        Human human5 = new Human(4, "Александр", Gender.male, LocalDate.of(1986, 6, 18), null, List<Human> parents, List<Human> children);
        Human human6 = new Human(5, "Татьяна", Gender.female, LocalDate.of(1982, 5, 23), null, List<Human> parents, List<Human> children);
        Human human7 = new Human(6, "Сергей", Gender.male, LocalDate.of(1978, 6, 8), null, List<Human> parents, List<Human> children);
        Human human8 = new Human(7, "Наталья", Gender.female, LocalDate.of(1960, 6, 21), null, List<Human> parents, List<Human> children);
        Human human9 = new Human(8, "Виктор", Gender.male, LocalDate.of(1960, 7, 2), null, List<Human> parents, List<Human> children);
        Human human10 = new Human(9, "Нина", Gender.female, LocalDate.of(1944, 4, 19), null, List<Human> parents, List<Human> children);
        Human human11 = new Human(10, "Вячеслав", Gender.male, LocalDate.of(1944, 6, 13), null, List<Human> parents, List<Human> children);

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);
        familyTree.addHuman(human7);
        familyTree.addHuman(human8);
        familyTree.addHuman(human9);
        familyTree.addHuman(human10);
        familyTree.addHuman(human11);

        System.out.println(familyTree);
    }
}
