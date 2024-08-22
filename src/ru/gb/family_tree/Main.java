package ru.gb.family_tree;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.HumanBuilder;
import ru.gb.family_tree.service.Service;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = testTree();

        System.out.println(tree);

        tree.sortByName();
        System.out.println("Сортировка по имени");
        System.out.println(tree);

        tree.sortByBirthDate();
        System.out.println("Сортировка по дате рождения");
        System.out.println(tree);
    }

    public static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();

        Human masha = new HumanBuilder()
                .setName("Мария")
                .setGender(Gender.female)
                .setBirthDate(LocalDate.of(1990, 8, 17))
                .build();

        Human sasha = new HumanBuilder()
                .setName("Александр")
                .setGender(Gender.male)
                .setBirthDate(LocalDate.of(1986, 6, 18))
                .build();

        Human tanya = new HumanBuilder()
                .setName("Татьяна")
                .setGender(Gender.female)
                .setBirthDate(LocalDate.of(1982, 5, 23))
                .build();

        Human sergey = new HumanBuilder()
                .setName("Сергей")
                .setGender(Gender.male)
                .setBirthDate(LocalDate.of(1978, 6, 8))
                .build();

        tree.addHuman(masha);
        tree.addHuman(sasha);
        tree.addHuman(tanya);
        tree.addHuman(sergey);

        Human veronika = new HumanBuilder()
                .setName("Вероника")
                .setGender(Gender.female)
                .setBirthDate(LocalDate.of(2022, 5, 24))
                .setMother(masha)
                .setFather(sasha)
                .build();

        Human luka = new HumanBuilder()
                .setName("Лука")
                .setGender(Gender.male)
                .setBirthDate(LocalDate.of(2016, 6, 19))
                .setMother(tanya)
                .setFather(sergey)
                .build();

        Human nikita = new HumanBuilder()
                .setName("Никита")
                .setGender(Gender.male)
                .setBirthDate(LocalDate.of(2009, 11, 23))
                .setMother(tanya)
                .setFather(sergey)
                .build();

        tree.addHuman(veronika);
        tree.addHuman(luka);
        tree.addHuman(nikita);

        Human grandMother = new HumanBuilder()
                .setName("Наталья")
                .setGender(Gender.female)
                .setBirthDate(LocalDate.of(1960, 6, 21))
                .build();

        Human grandFather = new HumanBuilder()
                .setName("Виктор")
                .setGender(Gender.male)
                .setBirthDate(LocalDate.of(1960, 7, 2))
                .build();

        grandMother.addChild(sasha);
        grandFather.addChild(sasha);
        grandMother.addChild(tanya);
        grandFather.addChild(tanya);

        tree.addHuman(grandMother);
        tree.addHuman(grandFather);

        Human grandMother1 = new HumanBuilder()
                .setName("Нина")
                .setGender(Gender.female)
                .setBirthDate(LocalDate.of(1944, 4, 19))
                .build();

        Human grandFather1 = new HumanBuilder()
                .setName("Вячеслав")
                .setGender(Gender.male)
                .setBirthDate(LocalDate.of(1944, 6, 13))
                .build();

        grandMother1.addChild(sergey);
        grandFather1.addChild(sergey);
        tree.addHuman(grandMother1);
        tree.addHuman(grandFather1);

        return  tree;
    }
}