package ru.gb.family_tree.model;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.family_tree.TreeNode;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.save.FileHandler;
import ru.gb.family_tree.model.save.Writable;

import java.time.LocalDate;

public class Service<T extends TreeNode<T>> {
    private FamilyTree<T> familyTree;
    private PersonFactory<T> factory;

    Writable fileHandler = new FileHandler();
    FamilyTreeManager manager = new FamilyTreeManager(fileHandler);
    private String filePath = "src/ru/gb/family_tree/model/save/tree.txt";

    public Service(PersonFactory<T> factory) {
        this.factory = factory;
        familyTree  = new FamilyTree<>();
    }

    public void addHuman(String name, String gender, LocalDate date) {
        T human = factory.createPerson(name, getGenderFromString(gender), date);
        familyTree.addHuman(human);
    }

   public void addChildren(int idParent, int idChild){
        familyTree.getById(idParent).addChild(familyTree.getById(idChild));
        familyTree.getById(idParent).getSpouse().addChild(familyTree.getById(idChild));
        familyTree.getById(idChild).addParent(familyTree.getById(idParent).getSpouse());
        familyTree.getById(idChild).addParent(familyTree.getById(idParent));
   }

    public String getHumanInfo(){
        String answer = familyTree.getInfo();
        return answer;
    }

    public void sotrByName() {
        familyTree.sortByName();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    public void saveFemaleTree() {
        manager.save(familyTree, filePath);
    }

    public void loadFemaleTree() {
        familyTree = manager.load(filePath);
    }

    public void setWedding(int idMale, int idFemale) {
        familyTree.setWedding(idMale, idFemale);
    }

    public static Gender getGenderFromString(String input) {
        if (input == null) {
            return null;
        }
        try {
            return Gender.valueOf(input);
        } catch (IllegalArgumentException e) {
            // Если введенная строка не соответствует ни одной из констант
            return null;
        }
    }

}
