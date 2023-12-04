package ru.gb.family_tree.writer;

import ru.gb.family_tree.FamilyTree;

import java.io.*;

public class FileHandler implements Writable {

    @Override
    public void save(Serializable serializable) {

        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.out"));
            objectOutputStream.writeObject(serializable);

            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void load(Serializable serializable) {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("person.out"));
            FamilyTree familyTree = (FamilyTree) objectInputStream.readObject();
            System.out.println(familyTree);
            objectInputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
