package ru.gb.family_tree;

import ru.gb.family_tree.writer.FileHandler;

import java.io.Serializable;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Ivan", Gender.MALE);
        Person person2 = new Person("Masha", Gender.FEMALE);
        Person person3 = new Person("Petya");

        FamilyTree familyTree = new FamilyTree();

        familyTree.addFamilyTreeMember(person1);
        familyTree.addFamilyTreeMember(person2);
        familyTree.addFamilyTreeMember(person3);
        familyTree.addParent(person1, person3);
        FileHandler fh = new FileHandler();

        familyTree.save(fh);
        familyTree.load(fh);

    }


}
