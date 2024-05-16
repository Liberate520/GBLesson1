package ru.gb.family_list.model.human;

import ru.gb.family_list.model.family.FamilyListItem;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Human implements Serializable, FamilyListItem {

    public enum Gender {
        MALE, FEMALE
    }

    private String name;
    private String surname;
    private Calendar dob, dod;
    private Human mother;
    private Human father;
    private final Gender gender;


    public Human(String name, String surname, Calendar dob, Gender gender, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, String surname, Calendar dob, Gender gender) {
        this(name, surname, dob, gender, null, null);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDob(Calendar dob) {
        this.dob = dob;
    }

    public void setDod(Calendar dod) {
        this.dod = dod;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }


    public int getAge() {
        if(dod != null) {
            return Period.between(getLocalDate(dob), getLocalDate(dod)).getYears();
        } else {
            return Period.between(getLocalDate(dob), LocalDate.now()).getYears();
        }
    }

    private LocalDate getLocalDate (Calendar calendar) {
        return new GregorianCalendar(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).toZonedDateTime().toLocalDate();
        }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        String dobString = (dob != null) ? sdf.format(dob.getTime()): "Неизвестно";
        String dodString = (dod != null) ? sdf.format(dod.getTime()) : "Неизвестно";

        String motherName = (mother != null) ? mother.getName() : "Неизвестно";
        String fatherName = (father != null) ? father.getName() : "Неизвестно";

        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dob=" + dobString +
                ", dod=" + dodString +
                ", mother=" + motherName +
                ", father=" + fatherName +
                '}';
    }
}
