package HumanTree_by_Krito;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private long humanId;
    private List<Human> humanList;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList){
        this.humanList = humanList;
    }

    public boolean add(Human human){
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humanId++);
            return true;
        }
        return false;
    }

    private boolean checkId(long id){
        return id < humanId && id >= 0;
    }

    public Human getById(long id){
        for (Human human: humanList){
            if (human.getId(human) == id){
                return human;
            }
        }
        return null;
    }

    public List<Human> getByInfo(String name){
        List<Human> res = new ArrayList<>();
        for (Human human: humanList){
            if (human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }


    public void setWedding(long id) {

    }
}
