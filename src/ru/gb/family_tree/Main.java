package ru.gb.family_tree;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.tree.FamilyTree;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Human parent1 = familyTree.addHuman(new Human("Sergei", "Ivanov", Gender.Male));
        Human parent2 = familyTree.addHuman(new Human("Natalia", "Ivanova", Gender.Female));

        familyTree.addSpouse(parent1.getId(), parent2.getId());

        Human human = familyTree.addHuman(new Human("Alex", "Ivanov", Gender.Male));

        familyTree.addChildren(parent1.getId(), Arrays.asList(human));
        familyTree.addChildren(parent2.getId(), Arrays.asList(human));
        familyTree.addParents(human.getId(), Arrays.asList(parent1, parent2));

        Human wife = familyTree.addHuman(new Human("Sveta", "Petrova", Gender.Female));

        familyTree.addSpouse(human.getId(), wife.getId());

        Human child1 = familyTree.addHuman(new Human("Olga", "Ivanova", Gender.Female));
        Human child2 = familyTree.addHuman(new Human("Petr", "Ivanov", Gender.Male));

        familyTree.addChildren(human.getId(), Arrays.asList(child1, child2));
        familyTree.addChildren(wife.getId(), Arrays.asList(child1, child2));
        familyTree.addParents(child1.getId(), Arrays.asList(human, wife));
        familyTree.addParents(child2.getId(), Arrays.asList(human, wife));

        System.out.println("Такое получилось дерево: ");
        familyTree.getHumanList().stream().forEach(System.out::println);
    }
}
