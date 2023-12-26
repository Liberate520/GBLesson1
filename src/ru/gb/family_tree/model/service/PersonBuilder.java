package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.Person;

import java.time.LocalDate;

public class PersonBuilder extends Builder<Person> {


    @Override
    PersonBuilder create() {
        member = new Person();
        return this;
    }

    @Override
    PersonBuilder buildName(String name) {
        member.setName(name);
        return this;
    }

    @Override
    PersonBuilder buildDateOfBirth(LocalDate date) {
        member.setDateOfBirth(date);
        return this;
    }

    @Override
    PersonBuilder buildDateOfDeath(LocalDate date) {
        member.setDateOfDeath(date);
        return this;
    }
}
