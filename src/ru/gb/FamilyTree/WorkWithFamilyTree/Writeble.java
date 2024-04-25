package ru.gb.FamilyTree.WorkWithFamilyTree;

import java.io.Serializable;

public interface Writeble {

    boolean saveFile(Serializable serializable, String filePath);

    Object readFile(String filePath);

}
