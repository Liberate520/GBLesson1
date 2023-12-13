package ru.gb.family_tree;

import ru.gb.family_tree.model.Gender;
import ru.gb.family_tree.model.Person;
import ru.gb.family_tree.writer.FileHandler;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Ivan", Gender.MALE);
        Person person2 = new Person("Masha", Gender.FEMALE);
        Person person3 = new Person("Petya");

        PersonService personService = new PersonService();

        personService.addFamilyTreeMember(person1);
        personService.addFamilyTreeMember(person2);
        personService.addFamilyTreeMember(person3);
        personService.addParent(person1, person3);
        FileHandler fh = new FileHandler();

        personService.save(fh);
        personService.load(fh);

        System.out.println(personService.getFamilyTreeInfo());

    }


}
