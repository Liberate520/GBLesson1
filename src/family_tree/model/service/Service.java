package family_tree.model.service;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.writer.FileHandler;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
    public FamilyTree<Human> familyTree;
    public FileHandler fileHandler;
    private int id = 1;

    public Service() {
        familyTree = new FamilyTree<>();
    }

    public void addHuman(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        Human human = new Human(id++, name, birthDate, deathDate, gender);
        familyTree.addSubject(human);
    }

    public void addMother(int motherID, int childID) {
        Human humanChild = findHumanByID(childID);
        if (humanChild != null) {
            for (Human humanParent : familyTree) {
                if (humanParent.getID() == motherID) {
                    humanChild.setMother(humanParent);
                }
            }
        }
    }

    public void addFather(int fatherID, int childID) {
        Human humanChild = findHumanByID(childID);
        if (humanChild != null) {
            for (Human humanParent : familyTree){
                if(humanParent.getID() == fatherID) {
                    humanChild.setFather(humanParent);
                }
            }
        }
    }

    public List<String> getParentName(int childID) {
        List<String> parents = new ArrayList<>();
        for (Human humanChild : familyTree) {
            if(humanChild.getID() == childID) {
                if ((humanChild.getMother() != null && humanChild.getFather() != null)) {
                    parents.add("mother: " + humanChild.getMother().getName());
                    parents.add("father: " + humanChild.getFather().getName());
                }
                else if (humanChild.getMother() != null && humanChild.getFather() == null) {
                    parents.add("mother: " + humanChild.getMother().getName());
                }
                else if (humanChild.getMother() == null && humanChild.getFather() != null) {
                    parents.add("father: " + humanChild.getFather().getName());
                }
            }
        }
        return parents;
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public String printFamilyTree() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Family tree:");
        strBuilder.append("\n");
        for (Human human : familyTree) {
            strBuilder.append(human);
            strBuilder.append("\n");
            return strBuilder.toString();
        }
        return null;
    }

    public boolean saveFile(String filePath) {
        boolean trySave;
        try {
            fileHandler.writeFamilyTree(familyTree, filePath);
            trySave = true;
        } catch (IOException e) {
            trySave = false;
        }
        return trySave;
    }

    public boolean loadFile(String filePath) {
        boolean tryLoad = true;
        Serializable loadFile;
        try {
            loadFile = fileHandler.readFamilyTree(filePath);
            familyTree = (FamilyTree<Human>) loadFile;
        } catch (IOException | ClassNotFoundException e) {
            tryLoad = false;
        }
        return tryLoad;
    }

    public Human findHumanByID(int requiredID) {
        Human result = null;
        for (Human human : familyTree) {
            if(human.getID() == requiredID) {
                result = human;
            }
        }
        return result;
    }
}
