package ru.gb.vending_machine.family_tree.service;


import ru.gb.vending_machine.family_tree.model.FamilyTree;
import ru.gb.vending_machine.family_tree.utils.FamilyTreeFileManager;

import java.io.*;

public class FamilyTreeFileManagerImpl<T> implements FamilyTreeFileManager<T> {

    @Override
    public void saveFamilyTree(FamilyTree<T> familyTree, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public FamilyTree<T> loadFamilyTree(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (FamilyTree<T>) ois.readObject();
        }
    }
}

