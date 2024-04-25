package ru.gb.study_group.Model.Student.Comporator;

import ru.gb.study_group.Model.Study_Group.StudyGroupElem;

import java.util.Comparator;

public class StudentsComporatorForName<E extends StudyGroupElem> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
