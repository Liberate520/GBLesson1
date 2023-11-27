package ru.gb.family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {

    private final List<Person> familyTree = new ArrayList<Person>();


    public void addFamilyTreeMember(Person person) {
        familyTree.add(person);
    }

    public String getFamilyTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Person person:familyTree)
        {
            stringBuilder.append(person);
        }
        return stringBuilder.toString();
    }

}
