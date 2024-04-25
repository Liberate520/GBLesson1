package ru.gb.FamilyTree.Human;

import ru.gb.FamilyTree.WorkWithFamilyTree.FamilyTreeElem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Comparable<Human>,FamilyTreeElem<Human> {
    private String name;
    private LocalDate dob, dod;
    private Gender gender;
    private List<Human> children;
    private Human mother, father;

    public Human(String name, LocalDate dob, LocalDate dod, Gender gender, Human mother, Human father) {
        this.name = name;
        this.dob = dob;
        this.dod = dod;
        this.gender = gender;
        children = new ArrayList<>();
        this.mother = mother;
        this.father = father;
    }
    public int getAge() {
        if(dod != null) {
            return dod.getYear() - dob.getYear();
        }
        else {
            return LocalDate.now().getYear() - dob.getYear();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDod() {
        return dod;
    }

    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Human> getChildren() {
        return children;
    }


    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getParents() {
        List<Human> list = new ArrayList<>();
        if (father != null) {
            list.add(father);
        }
        if (mother != null) {
            list.add(mother);
        }
        return list;
    }


    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя- ");
        sb.append(getName());
        sb.append(" Дата рождения- ");
        sb.append(getDob());
        sb.append(" Дата смерти- ");
        sb.append(getDod());
        sb.append(" Пол- ");
        sb.append(getGender());
        sb.append(" Дети- ");
        sb.append(getChildrenInfo());
        sb.append(" Мать- ");
        sb.append(getGlobalInfo(mother));
        sb.append(" Отец- ");
        sb.append(getGlobalInfo(father));
        return sb.toString();
    }

    public String getChildrenInfo() {
        StringBuilder sb = new StringBuilder();
        for (Human child : children) {
            sb.append(child.getInfo());
        }
        return sb.toString();

    }

//    public String getMotherInfo() {
//        StringBuilder sb = new StringBuilder();
//        if(mother != null) {
//            sb.append(mother.getName()).append(" ").append(mother.getDob());
//            return sb.toString();
//        }
//        return null;
//    }

    public String getGlobalInfo(Human field) {
        StringBuilder sb = new StringBuilder();
        if(field != null) {
            sb.append(field.getName()).append(" ").append(field.getDob());
            return sb.toString();
        }
        return "Данные отсутствуют  ";
    }


    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }




}


