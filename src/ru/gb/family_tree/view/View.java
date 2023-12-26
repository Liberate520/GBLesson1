package ru.gb.family_tree.view;

import ru.gb.family_tree.model.Person;
import ru.gb.family_tree.model.writer.SavingType;

public interface View {
    void print(String text);

    void start();

    String read();

    void printf(String text, String placeHolder);

    void finish();

    void addFamilyTreeMember(String name, String sGender);


    void getFamilyTreeInfo();

    void sortByName();

    void sortByAge();

    void save(SavingType savingType);
    void load(SavingType savingType);
}

