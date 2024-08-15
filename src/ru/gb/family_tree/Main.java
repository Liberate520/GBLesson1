package ru.gb.family_tree;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = testTree();
        System.out.println(tree);
    }

    public static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();

        Human masha = new Human("Мария", Gender.female, LocalDate.of(1990, 8, 17));
        Human sasha = new Human("Александр", Gender.male, LocalDate.of(1986, 6, 18));
        Human tanya = new Human("Татьяна", Gender.female, LocalDate.of(1982, 5, 23));
        Human sergey = new Human("Сергей", Gender.male, LocalDate.of(1978, 6, 8));

        tree.addHuman(masha);
        tree.addHuman(sasha);
        tree.addHuman(tanya);
        tree.addHuman(sergey);

        Human veronika = new Human("Вероника", Gender.female, LocalDate.of(2022, 5, 24), masha, sasha);
        Human luka = new Human("Лука", Gender.male, LocalDate.of(2016, 6, 19), tanya, sergey);
        Human nikita = new Human("Никита", Gender.male, LocalDate.of(2009, 11, 23), tanya, sergey);

        tree.addHuman(veronika);
        tree.addHuman(luka);
        tree.addHuman(nikita);

        Human grandMother = new Human("Наталья", Gender.female, LocalDate.of(1960, 6, 21));
        Human grandFather = new Human("Виктор", Gender.male, LocalDate.of(1960, 7, 2));

        grandMother.addChild(sasha);
        grandFather.addChild(sasha);
        grandMother.addChild(tanya);
        grandFather.addChild(tanya);

        tree.addHuman(grandMother);
        tree.addHuman(grandFather);

        Human grandMother1 = new Human("Нина", Gender.female, LocalDate.of(1944, 4, 19));
        Human grandFather1 = new Human("Вячеслав", Gender.male, LocalDate.of(1944, 6, 13));

        grandMother1.addChild(sergey);
        grandFather1.addChild(sergey);
        tree.addHuman(grandMother1);
        tree.addHuman(grandFather1);

        return  tree;
    }
}
