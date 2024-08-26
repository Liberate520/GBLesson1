package ru.gb.family_tree;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.model.Gender;
import ru.gb.family_tree.model.Human;
import ru.gb.family_tree.model.Service;
import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.View;
import ru.gb.family_tree.writer.FileHandler;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    final static String fileName = "src/ru/gb/family_tree/writer/family_tree.txt";
    public static void main(String[] args) {
        Service service = new Service();
        service.addHuman("Мария", Gender.female, LocalDate.of(1990, 8, 17), null, null, null, new ArrayList<>());
        service.addHuman("Александр", Gender.male, LocalDate.of(1986, 6, 18), null, null, null, new ArrayList<>());
        service.addHuman("Татьяна", Gender.female, LocalDate.of(1982, 5, 23), null, null, null, new ArrayList<>());
        service.addHuman("Сергей", Gender.male, LocalDate.of(1978, 6, 8), null, null, null, new ArrayList<>());
        Human masha = service.getByName("Мария").get(0);
        Human sasha = service.getByName("Александр").get(0);
        service.addHuman("Вероника", Gender.female, LocalDate.of(2022, 5, 24), null, masha, sasha, new ArrayList<>());
        Human tanya = service.getByName("Татьяна").get(0);
        Human sergey = service.getByName("Сергей").get(0);
        service.addHuman("Лука", Gender.male, LocalDate.of(2016, 6, 19), null, tanya, sergey, new ArrayList<>());
        service.addHuman("Никита", Gender.male, LocalDate.of(2009, 11, 23), null, tanya, sergey, new ArrayList<>());
        service.addHuman("Наталья", Gender.female, LocalDate.of(1960, 6, 21), null, null, null, new ArrayList<>());
        service.addHuman("Виктор", Gender.male, LocalDate.of(1960, 7, 2), null, null, null, new ArrayList<>());
        Human natasha = service.getByName("Наталья").get(0);
        Human viktor = service.getByName("Виктор").get(0);
        natasha.addChild(sasha);
        natasha.addChild(tanya);
        viktor.addChild(sasha);
        viktor.addChild(tanya);
        service.addHuman("Нина", Gender.female, LocalDate.of(1944, 4, 19), null, null, null, new ArrayList<>());
        service.addHuman("Вячеслав", Gender.male, LocalDate.of(1944, 6, 13), null, null, null, new ArrayList<>());
        Human nina = service.getByName("Нина").get(0);
        Human vyacheslav = service.getByName("Вячеслав").get(0);
        nina.addChild(sergey);
        vyacheslav.addChild(sergey);

        System.out.println(service.getHumanListInfo());

        View view = new ConsoleUI();
        view.start();

//        FamilyTree tree = load();
//        FamilyTree tree = testTree();
//        saveFile(tree);

//        System.out.println(tree);

        service.sortByName();
        System.out.println("Сортировка по имени");
        System.out.println(service);

        service.sortByBirthDay();
        System.out.println("Сортировка по дате рождения");
        System.out.println(service);
    }
    private static FamilyTree<Human> load(){
        FileHandler fileHandler = new FileHandler(fileName);
        return (FamilyTree<Human>) fileHandler.readFile();
    }

    public static void saveFile(FamilyTree familyTree) {
        FileHandler fileHandler = new FileHandler(fileName);
        fileHandler.saveFile(familyTree);
    }
}