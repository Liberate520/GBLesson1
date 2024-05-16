package ru.gb.family_list.writer;

import java.io.*;

public class SerializableFileHandler<E extends Serializable> extends FileHandler<E> {

    private String filetype;

    public SerializableFileHandler() {
        this.filetype = "non human readable file";
    }

    @Override
    public void write(E o, String path) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(path));
            objectOutputStream.writeObject(o);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public E read(String path){
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(path));
            E dateRestored = (E) objectInputStream.readObject();
            objectInputStream.close();
            return dateRestored;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
