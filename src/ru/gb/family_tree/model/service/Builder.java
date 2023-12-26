package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.Member;

import java.time.LocalDate;

public abstract class Builder<T extends Member> {
    protected T member;

    abstract Builder<T> create();

    abstract Builder<T> buildName(String name);

    abstract Builder<T> buildDateOfBirth(LocalDate date);

    abstract Builder<T> buildDateOfDeath(LocalDate date);


    public T build() {
        return member;
    }

}
