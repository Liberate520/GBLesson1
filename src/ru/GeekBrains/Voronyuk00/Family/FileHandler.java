package ru.GeekBrains.Voronyuk00.Family;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class FileHandler implements Writable{
	
	/*
	 * Метод для сохранения в файл;
	 */
	@Override
	public void saveInFile(Serializable serializable) throws IOException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("familyTree.txt"));
		objectOutputStream.writeObject(serializable);
		objectOutputStream.close();
	}

	@Override
	public Object loadFromFile() throws IOException, ClassNotFoundException {
		ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("familyTree.txt"));
		Object obj = objectInputStream.readObject();
		objectInputStream.close();
		return obj;
		
	}

}
