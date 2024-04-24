package family_tree.model.human;

import family_tree.model.family_tree.TreeN;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class  Human implements Serializable, TreeN<Human> {
    private String name;
    private LocalDate dob, dad;
    private Gender gender;
    private List<String> children;
    private int age;
    private Human mother;
    private Human father;

    public Human(String name, LocalDate dob, LocalDate dad, Gender gender, int age, Human mother, Human father) {
        this.name = name;
        this.dob = dob;
        this.dad = dad;
        this.gender = gender;
        this.age = age;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<String>();
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public boolean addChild(String child) {
        if (!children.contains(child)) {
            children.add(child);

            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)){
            setMother(parent);
        }
        return true;
    }

    private void setMother(Human parent) {
    }

    private void setFather(Human parent) {
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean addChild(Human human) {
        return false;
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

    public LocalDate getDad() {
        return dad;
    }

    public void setDad(LocalDate dad) {
        this.dad = dad;
    }

    public List getChildren() {
        return children;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List getParents() {
        List<String> list = new ArrayList<>(2);
        if (father != null) {
            list.add(String.valueOf(father));
        }
        if (mother != null) {
            list.add(String.valueOf(mother));
        }
        return list;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sbuild = new StringBuilder();
        sbuild.append("Имя: ");
        sbuild.append(name);
        sbuild.append(", дата рождения: ");
        sbuild.append(dob);
        sbuild.append(", дата смерти: ");
        sbuild.append(dad);
        sbuild.append(", пол: ");
        sbuild.append(getGender());
        sbuild.append(", возраст: ");
        sbuild.append(age);
        sbuild.append(", имя матери: ");
        sbuild.append(mother);
        sbuild.append(", имя отца: ");
        sbuild.append(father);
        return sbuild.toString();
    }

}