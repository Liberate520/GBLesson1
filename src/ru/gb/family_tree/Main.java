package ru.gb.family_tree;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.service.Service;
import ru.gb.family_tree.tree.FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.addHuman("Nataly", "Ural", Gender.Female, LocalDate.of(1965, 2, 2));
        service.addHuman("Nikolay", "Donetsk", Gender.Male, LocalDate.of(1962, 10, 10));
        service.addHuman("Denis", "Krasnodar", Gender.Male, LocalDate.of(1987, 7, 7), 1, 2);
        service.addHuman("Jane", "Murmansk", Gender.Female, LocalDate.of(1991, 5, 5));
        service.addHuman("Alice", "Sochi", Gender.Female, LocalDate.of(2016, 12, 12), 4, 3);
        service.addHuman("Nataly", "Murmansk", Gender.Female, LocalDate.of(1971, 8, 8));
        service.addHuman("Helen", "Krasnodar", Gender.Female, LocalDate.of(1993, 6, 6), 1, 2);
        service.addChildToHuman(6, 4);
        service.sortByName();
        service.print();
        service.sortByAge();
        service.print();
        service.save("src/ru/gb/family_tree/storage/NewTreeNonStatic.out");
        service.load("src/ru/gb/family_tree/storage/NewTreeNonStatic.out");
        System.out.println(service.getHumansList());
    }
}



