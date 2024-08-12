package ru.gb.family_tree;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate, deadDate;
    private List<Human> parents;
    private List<Human> children;

    public Human(int id, String name, Gender gender, LocalDate birthDate, LocalDate deadDate, List<Human> parents, List<Human> children) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deadDate = deadDate;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String calculateAgeOrDeathDate(LocalDate currentDate) {
        if (deadDate != null) {
            return "Died on: " + deadDate.toString();
        } else {
            int age = Period.between(birthDate, currentDate).getYears();
            return "Age: " + age;
        }
    }

    public List<FamilyTree> getParents(FamilyTree human) {
        if(human.equals("Вероника")) {
            System.out.println("mother: " + getByName(human4) + ", father: " + getByName(human5));
        }
        else if(human.equals("Лука" || "Никита")) {
            System.out.println("mother: " + getByName(human6) + ", father: " + getByName(human7));
        }
        else if(human.equals("Александр" || "Татьяна")) {
            System.out.println("mother: " + getByName(human8) + ", father: " + getByName(human9));
        }
        else if(human.equals("Сергей")) {
            System.out.println("mother: " + getByName(human10) + ", father: " + getByName(human11));
        }
    }

    public List<FamilyTree> getChildren(FamilyTree human) {
        if(human.equals("Вероника" || "Лука" || "Никита")) {
            System.out.println("children: " + null);
        }
        else if(human.equals("Мария" || "Александр")) {
            System.out.println("children: " + getByName(human1));
        }
        else if(human.equals("Татьяна" || "Сергей")) {
            System.out.println("children: " + getByName(human2) + ", " + getByName(human3));
        }
        else if(human.equals("Наталья" || "Виктор")) {
            System.out.println("children: " + getByName(human8) + ", " + getByName(human9));
        }
        else if(human.equals("Нина" || "Вячеслав")) {
            System.out.println("children: " + getByName(human7));
        }
    }

    LocalDate currentDate = LocalDate.now();
    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", gender: " + gender + ", " + calculateAgeOrDeathDate(currentDate) + ", " + getParents(humans) + ", " + getChildren(humans);
    }
}
