package ru.gb.family_tree.writer;

import java.io.*;

public class FileHandler implements Writer {
    private String fileName;

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean saveFile(Serializable serializable) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object readFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
