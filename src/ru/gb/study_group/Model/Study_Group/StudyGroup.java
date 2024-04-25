package ru.gb.study_group.Model.Study_Group;

import ru.gb.study_group.Model.Student.Comporator.StudentsComporatorForAge;
import ru.gb.study_group.Model.Student.Students;
import ru.gb.study_group.Model.Study_Group.Iterators.StudentsIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class StudyGroup implements Iterable<Students> {
    private List<Students> studentsList;

    public StudyGroup() {
        studentsList = new ArrayList<>();
    }

    public void addStudent(Students student) {
        studentsList.add(student);
    }

    public void sortByName() {
        Collections.sort(studentsList);
    }

    public void sortByAge() {
        studentsList.sort(new StudentsComporatorForAge());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StudyGroup{");
        sb.append("studentsList=").append(studentsList);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Iterator<Students> iterator() {
        return new StudentsIterator(studentsList);
    }


}
