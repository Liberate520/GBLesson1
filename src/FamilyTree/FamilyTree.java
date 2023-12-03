package FamilyTree;

import FamilyTree.HR.Human;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private int countPeople;

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
            human.setId(countPeople++);

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
        return id < countPeople && id >= 0;
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
        StringBuilder ftbase = new StringBuilder();
        ftbase.append("\n В дереве ");
        ftbase.append(humanList.size());
        ftbase.append(" объектов: \n");        for (Human human: humanList){
            ftbase.append(human);
            ftbase.append("\n");
        }

        return ftbase.toString();
    }

}
