package ru.gb.vending_machine.family_tree;

import java.io.*;
import java.util.List;

public class FileIO implements FileIOInterface {
    @Override
    public void writeToFile(String fileName, List<Person> people) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(people);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> readFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Person>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}