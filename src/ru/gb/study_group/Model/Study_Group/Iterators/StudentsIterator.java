package ru.gb.study_group.Model.Study_Group.Iterators;

import ru.gb.study_group.Model.Student.Students;

import java.util.Iterator;
import java.util.List;

public class StudentsIterator implements Iterator<Students> {

    private List<Students> studentsList;

    public StudentsIterator(List<Students> studentsList) {
        this.studentsList = studentsList;
    }

    private int index;

    @Override
    public boolean hasNext() {
        return index < studentsList.size();
    }

    @Override
    public Students next() {
        return studentsList.get(index++);
    }
}