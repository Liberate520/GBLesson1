package GBLesson1.src.ru.gb.FamilyTree.Human;

import GBLesson1.src.ru.gb.vending_machine.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private int id = 1;
    private Gender gender;
    private int age;
    private String name;
    private String surname;
    private MotFath MotFath;
    private List<String> children;


    public Human(Gender gender, int age, String name, String surname, MotFath MothFath, List<String> children) {
        this.gender = gender;
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.MotFath = MothFath;
        this.children = children;
    }


    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ", name: " + name + ", surname: " + surname +  ", age: " + age + ", gender: " + gender
                + ", status: " + MotFath + ", children: " + children;
    }

}
