package ru.gb.family_tree.view;

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

    void saveToFile();
    void loadFromFile();
}

