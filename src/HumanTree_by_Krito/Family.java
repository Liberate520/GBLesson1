package HumanTree_by_Krito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Family extends Human{
    private List<Human> children;
    private Human father, mother;
    private List<Human> parents;
    private Human spouse;


    public Family(String name, LocalDate birthDate, Gender gender, Human father, Human mother){
        super(name, gender,birthDate);
        this.father = father;
        this.mother = mother;
        parents = new ArrayList<>();
        if (father != null){
            parents.add(father);
        }
        if (mother != null){
            parents.add(mother);
        }
        children = new ArrayList<>();
    }

    public Human getFather(){
        for (Human parent: parents){
            if (parent.getGender() == Gender.Male){
                return parent;
            }
        }
        return null;
    }

    public Human getMother(){
        for (Human parent: parents){
            if (parent.getGender() == Gender.Female){
                return parent;
            }
        }
        return null;
    }

    public boolean addChild(Human child){
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("не появилиь");
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId(human) == getId(human);
    }

    @Override
    public String toString(){
    return getInfo();
    }

    public String getInfo() {
        StringBuilder sd = new StringBuilder();
        sd.append(", Отец: ");
        sd.append(getFather());
        sd.append(", Мать: ");
        sd.append(getMother());
        sd.append(", Дети: ");
        sd.append(getChildrenInfo());
        return sd.toString();
    }
}
