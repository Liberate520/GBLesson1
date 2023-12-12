package ru.gb.family_tree;

import ru.gb.family_tree.person.Gender;
import ru.gb.family_tree.person.Person;
import ru.gb.family_tree.writer.FileHandler;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Ivan", Gender.MALE);
        Person person2 = new Person("Masha", Gender.FEMALE);
        Person person3 = new Person("Petya");

        Service service = new Service();

        service.addFamilyTreeMember(person1);
        service.addFamilyTreeMember(person2);
        service.addFamilyTreeMember(person3);
        service.addParent(person1, person3);
        FileHandler fh = new FileHandler();

        service.save(fh);
        service.load(fh);

        System.out.println(service.getFamilyTreeInfo());

    }


}
