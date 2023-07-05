package ru.gb.family_tree.handler;

import ru.gb.family_tree.tree.FamilyTree;

import java.io.*;

public class FileHandler implements Writable {
    String path;

    public FileHandler(String path) {
        this.path = path;
    }

    @Override
    public void save(FamilyTree familyTree) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path, false))) {
            objectOutputStream.writeObject(familyTree);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public FamilyTree read() {
        FamilyTree familyTree = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(path))) {
            familyTree = (FamilyTree) objectInputStream.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return familyTree;
    }
}
