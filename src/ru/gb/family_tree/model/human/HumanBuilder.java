package ru.gb.family_tree.model.human;

import ru.gb.family_tree.model.tree.FamilyTree;

import java.time.LocalDate;

public class HumanBuilder {
    private long id = 1;

    public Human build(String name, String birthPlace, Gender gender, LocalDate birthDate) {
        return new Human(id++, name, birthPlace, gender, birthDate);
    }

    public Human build(String name, String birthPlace, Gender gender, LocalDate birthDate, int parentID, FamilyTree tree) {
        Human parent = (Human) tree.getParent(parentID);
        if (parent != null && parent.getGender() == Gender.Female)
            return new Human(id++, name, birthPlace, gender, birthDate, parent, null);
        else if (parent != null && parent.getGender() == Gender.Male)
            return new Human(id++, name, birthPlace, gender, birthDate, null, parent);
        else {
            return new Human(id++, name, birthPlace, gender, birthDate);
        }
    }

    public Human build(String name, String birthPlace, Gender gender, LocalDate birthDate, int motherID, int fatherID, FamilyTree tree) {
        Human mom = (Human) tree.getParent(motherID);
        Human dad = (Human) tree.getParent(fatherID);
        return new Human(id++, name, birthPlace, gender, birthDate, mom, dad);
    }
}
