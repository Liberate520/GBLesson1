package ru.gb.FamilyTree;

import ru.gb.FamilyTree.Trees.FamilyTree;

import java.io.*;


public class FamilyTreeFileHandler implements FamilyTreeManager {
    @Override
    public void saveFamilyTree(FamilyTree familyTree, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(familyTree);
            System.out.println("Семейное древо сохранено в файл: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FamilyTree loadFamilyTree(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            FamilyTree familyTree = (FamilyTree) ois.readObject();
            System.out.println("Семейное древо загружено из файла: " + filename);
            return familyTree;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}