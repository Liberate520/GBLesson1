package ru.gb.FamilyTree.WorkWithFamilyTree;

import java.io.*;

public class FileHandler implements Writeble {
   public boolean saveFile(Serializable serializable, String filePath) {
       try(ObjectOutputStream objectOutputStream = new ObjectOutputStream
               (new FileOutputStream(filePath))) {
           objectOutputStream.writeObject(serializable);
           return true;
       } catch (Exception e) {
           e.printStackTrace();
           return false;
       }
   }

   public Object readFile(String filePath) {
       try (ObjectInputStream objectInputStream =new ObjectInputStream
               (new FileInputStream(filePath))) {
           return objectInputStream.readObject();
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }
}
