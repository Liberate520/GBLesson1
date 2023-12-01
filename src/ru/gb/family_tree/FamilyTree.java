package ru.gb.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private long humansID;
    private List<Human> humanList;

    public FamilyTree(){this(new ArrayList<>());}

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humansID++);


            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToChildren(Human human) {
        for(Human child: human.getChildren()){
            child.addParent(human);
        }
    }

    private void addToParents(Human human) {
        for(Human parent: human.getParents()){
            parent.addChild(human);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Human human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
}
