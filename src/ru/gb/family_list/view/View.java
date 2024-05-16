package ru.gb.family_list.view;

import java.io.IOException;

public interface View {
    public void start() throws IOException, ClassNotFoundException;
    public void printAnswer(String text);
}
