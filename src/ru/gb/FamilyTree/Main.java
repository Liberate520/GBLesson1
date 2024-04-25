package ru.gb.FamilyTree;

import ru.gb.FamilyTree.FamilyTree.FamilyTree;
import ru.gb.FamilyTree.Human.Gender;
import ru.gb.FamilyTree.Human.Human;
import ru.gb.FamilyTree.WorkWithFamilyTree.FamilyTreeElem;
import ru.gb.FamilyTree.WorkWithFamilyTree.HumanComporator;

import java.io.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {

        Human dmitry = new Human("Дмитрий", LocalDate.of(1981, 3, 17),
                null, Gender.Male, null, null);
        Human valery = new Human("Валерия", LocalDate.of(2005, 10, 5),
                null, Gender.Female, null, null);
        Human alina = new Human("Алина", LocalDate.of(1980, 6, 4),
                null, Gender.Female, null, null);
        Human nataly = new Human("Наталья", LocalDate.of(1961, 6, 1),
                null, Gender.Female, null, null);
        Human alexandr = new Human("Александр", LocalDate.of(1956, 12, 9),
                null, Gender.Male, null, null);
        Human margo = new Human("Маргарита", LocalDate.of(1932, 2, 23),
                null, Gender.Female, null, null);
        Human boris = new Human("Борис", LocalDate.of(1931, 8, 12),
                LocalDate.of(2008, 8, 16), Gender.Male, null, null);

        String filePath = "C:\\Learning\\JavaProject\\src\\ru\\gb\\FamilyTree\\FileHandler\\familytree.txt";
        FamilyTree familyTree = new FamilyTree();


        dmitry.setFather(alexandr);
        dmitry.addChild(valery);
        alina.addChild(valery);
        valery.setFather(dmitry);
        valery.setMother(alina);
        dmitry.setMother(nataly);
        nataly.setMother(margo);
        nataly.setFather(boris);
        nataly.addChild(dmitry);
        boris.addChild(nataly);
        margo.addChild(nataly);
        alexandr.addChild(dmitry);


        familyTree.addMember(dmitry);
        familyTree.addMember(valery);
        familyTree.addMember(alina);
        familyTree.addMember(nataly);
        familyTree.addMember(margo);
        familyTree.addMember(alexandr);
        familyTree.addMember(boris);


//        System.out.println(nataly.getAge());
//        System.out.println(dmitry.getGlobalInfo(dmitry.getMother()));


//        for (Human o : familyTree) {
//            System.out.println(o.getDob() + " " + o.getName());
//        }


        familyTree.sortByAge();
        System.out.println(familyTree);
        familyTree.sortByName();
        System.out.println(familyTree);



    }
}
