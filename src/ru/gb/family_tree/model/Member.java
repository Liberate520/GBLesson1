package ru.gb.family_tree.model;

public abstract class Member {

    abstract public Gender getGender();

    abstract public void setFather(Member father);

    abstract public void setMother(Member mother);
    abstract public void addChild (Member child);


}
