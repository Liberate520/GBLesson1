package ru.gb.study_group.Model.Student;

public class Students implements Comparable<Students> {
    private String name;
    private  int id;
    private int age;

    public Students(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Students{");
        sb.append("name='").append(name).append('\'');
        sb.append(", id=").append(id);
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }


    @Override
    public int compareTo(Students o) {
        return name.compareTo(o.name);
    }


}
