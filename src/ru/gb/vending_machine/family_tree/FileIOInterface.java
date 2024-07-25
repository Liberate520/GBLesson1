package ru.gb.vending_machine.family_tree;

import java.util.List;

public interface FileIOInterface {
    void writeToFile(String fileName, List<Person> people);
    List<Person> readFromFile(String fileName);
}
