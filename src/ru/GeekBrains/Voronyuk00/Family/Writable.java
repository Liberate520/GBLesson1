package ru.GeekBrains.Voronyuk00.Family;

import java.io.IOException;
import java.io.Serializable;


public interface Writable {
	void saveInFile(Serializable serialazable) throws IOException;
	Object loadFromFile() throws IOException, ClassNotFoundException;
}
