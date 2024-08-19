package ru.gb.family_tree.writer;

import ru.gb.family_tree.family_tree.FamilyTree;

import java.io.*;

public class FileHandler implements ru.gb.family_tree.writer.Writer {
    public static void saveToFile(FamilyTree familyTree, String fileName) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(familyTree);
        }
    }

    public static FamilyTree loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (FamilyTree) in.readObject();
        }
    }
}
