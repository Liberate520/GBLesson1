package ru.gb.family_tree.model;

import java.time.LocalDate;

public abstract class Member<T> {

    abstract public Gender getGender();

    abstract public void setFather(T father);

    abstract public void setMother(T mother);

    abstract public void addChild(T child);

    abstract public LocalDate getDateOfBirth();

    abstract public String getName();

}
