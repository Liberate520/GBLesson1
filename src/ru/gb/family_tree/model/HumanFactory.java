package ru.gb.family_tree.model;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;

import java.time.LocalDate;

public class HumanFactory implements PersonFactory<Human> {
    @Override
    public Human createPerson(String name, Gender gender, LocalDate birthDate) {
        return new Human(name, gender, birthDate);
    }
}

