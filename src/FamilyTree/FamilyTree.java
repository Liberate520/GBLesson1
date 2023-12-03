package FamilyTree;

import java.io.Serializable;
import FamilyTree.HR.Human;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable{
    private int countPeopleInTree;

    private List<Human> humanList;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public boolean add(Human human){
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(countPeopleInTree++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(Human human){
        for(Human parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human){
        for (Human child: human.getChildren()){
            child.addParent(human);
        }
    }


    public boolean remove(int humansId){
        if (checkId(humansId)){
            Human e = getById(humansId);
            return humanList.remove(e);
        }
        return false;
    }
    private boolean checkId(long id) {
        return id < countPeopleInTree && id >= 0;
    }
    public Human getById(long id){
        if (checkId(id)){
            for (Human human: humanList){
                if (human.getId() == id) {
                    return human;
                }
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo(){
        StringBuilder familytreebase = new StringBuilder();
        familytreebase.append("\n В дереве ");
        familytreebase.append(humanList.size());
        familytreebase.append(" объектов: \n");
        for (Human human: humanList){
            familytreebase.append(human);
            familytreebase.append("\n");
        }

        return familytreebase.toString();
    }

}
