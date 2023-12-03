package FamilyTree.HR;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable{

    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private String place_of_residence;
    private Human mother;
    private Human father;
    private Human spouse;
    private final List<Human> children;

    public Human(String name, Gender gender, LocalDate birthDate, String place_of_residence, LocalDate deathDate, Human father, Human mother) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
        this.place_of_residence = place_of_residence;
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        this(name, gender, birthDate, null, null, father, mother);
    }
    public Human(String name, Gender gender, LocalDate birthDate, Human mother) {
        this(name, gender, birthDate, null, null, null, mother);
    }
    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this(name, gender, birthDate, null, deathDate, null, null);
    }
    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null, null);
    }
    public Human(String name, Gender gender, String place_of_residence, LocalDate deathDate) {
        this(name, gender, null, place_of_residence, deathDate, null, null);
    }

    public void setId(int id){
        this.id = id;
    }
    public long getId(){
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public Gender getGender(){
        return gender;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public LocalDate getBirthDate(){
        return birthDate;
    }
    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }
    public LocalDate getDeathDate(){
        return deathDate;
    }
    public void setFather(Human father) {
        this.father = father;
    }
    public Human getFather() {
        return father;
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }
    public Human getMother() {
        return mother;
    }
    public List<Human> getChildren(){
        return children;
    }
    public void setSpouse(Human spouse){
        this.spouse = spouse;
    }
    public Human getSpouse(){
        return spouse;
    }
    public void setPlace_of_residence(String place_of_residence) {
        this.place_of_residence = place_of_residence;
    }
    public String getPlace_of_residence(){
        return place_of_residence;
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if(parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        }
        else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
        return true;
    }

    public List<Human> getParents(){
        List<Human> list = new ArrayList<Human>(2);
        if (father != null) {
            list.add(father);
        }
        if (mother != null) {
            list.add(mother);
        }
        return list;
    }

    public int getAge(){
        if (deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        }
        else{
            return getPeriod(birthDate, deathDate);
        }
    }
    public LocalDate getLived(){
        if (deathDate != null){
            return deathDate;
        }
        return null;
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }


    public String getMotherInfo(){

        return null;
    }
    public String getFatherInfo(){

        return null;
    }

    public String getChildrenInfo(){
        StringBuilder children = new StringBuilder();
        children.append("дети: ");
        if (!this.children.isEmpty()) {
            children.append(this.children.get(0).getName());
            for (int i = 1; i < this.children.size(); i++) {
                children.append(", ");
                children.append(this.children.get(i).getName());
            }
        }
        else {
            children.append("отсутствуют");
        }
        return children.toString();
    }
    public String getSpouseInfo(){

        return null;
    }
    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo(){
        StringBuilder familytreebase = new StringBuilder();
        familytreebase.append("id: ");
        familytreebase.append(id);
        familytreebase.append(", имя: ");
        familytreebase.append(name);
        familytreebase.append(", пол: ");
        familytreebase.append(getGender());
        familytreebase.append(", ");
        familytreebase.append(", проживает в ");
        familytreebase.append(getPlace_of_residence());
        familytreebase.append(", ");
        familytreebase.append(getLived());
        familytreebase.append(", возраст: ");
        familytreebase.append(getAge());
        familytreebase.append(", супруг(а): ");
        familytreebase.append(getSpouseInfo());
        familytreebase.append(", ");
        familytreebase.append(getMotherInfo());
        familytreebase.append(", ");
        familytreebase.append(getFatherInfo());
        familytreebase.append(", ");
        familytreebase.append(getChildrenInfo());
        return familytreebase.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }

}
