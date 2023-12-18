package ru.gb.family_tree.view;

public interface View {
    void print(String text);

    void start();

    String read();

    void printf(String text, String placeHolder);

    void finish();
}

