package ru.gb.family_tree.human;

import ru.gb.family_tree.family_tree.FamilyTreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements FamilyTreeItem<Human>, Serializable {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deadDate;
    private Human mother;
    private Human father;
    private List<Human> children;


    public Human() {
        id = -1;
        children = new ArrayList<>();
    }

    @Override
    public void addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    @Override
    public void addParent(Human parent) {
        if (parent == null || parent.getGender() == null) {
            return;
        }
        if (parent.getGender().equals(Gender.male)) {
            setFather(parent);
        } else if (parent.getGender().equals(Gender.female)) {
            setMother(parent);
        }
    }

    public void setGender(Gender gender) {this.gender = gender;}

    public void setName(String name) {this.name = name;}

    public void setMother(Human mother) {this.mother = mother;}

    public void setFather(Human father) {this.father = father;}

    public Human getMother() {return mother;}

    public Human getFather() {return father;}

    public List<Human> getParents() {
        List<Human> list = new ArrayList<>(2);
        if(father != null) {
            list.add(father);
        }
        if (mother != null) {
            list.add(mother);
        }
        return  list;
    }

    @Override
    public int getAge() {
        if (deadDate != null) {
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deadDate);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deadDate) {
        Period diff = Period.between(birthDate, deadDate);
        return diff.getYears();
    }

    @Override
    public String getName() {return name;}

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public LocalDate getBirthDate() {return birthDate;}

    public LocalDate getDeadDate() {return deadDate;}

    public List<Human> getChildren() {return children;}

    public void setBirthDate(LocalDate birthDate) {this.birthDate = birthDate;}

    public void setDeadDate(LocalDate deadDate) {this.deadDate = deadDate;}

    public Gender getGender() {return gender;}

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", name: ");
        sb.append(name);
        sb.append(", gender: ");
        sb.append(getGender());
        sb.append(", age: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildenInfo());
        return sb.toString();
    }

    public String getMotherInfo() {
        String res = "mother: ";
        Human mother = getMother();
        if(mother != null) {
            res += mother.getName();
        } else {
            res += "нет";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "father: ";
        Human father = getFather();
        if(father != null) {
            res += father.getName();
        } else {
            res += "нет";
        }
        return res;
    }

    public String getChildenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("kids: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("нет.");
        }
        return res.toString();
    }

    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}