package HumanTree_by_Krito;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Human {
    private long id;
    private String name;
    private LocalDate birthDate;
    private LocalDate deadDate;
    private Gender gender;

    public Human(String name, Gender gender, LocalDate birthDate) {
        id = -1;
        this.name = name.toString();
        this.gender = gender;
        this.birthDate = birthDate;
        this.deadDate = deadDate;
    }


    public long getId(Human human) {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeadDate() {
        return deadDate;
    }

    public void setDeadDate(LocalDate deadDate) {
        this.deadDate = deadDate;
    }

    public int getAge() {
        return getPeriod(birthDate, Objects.requireNonNullElseGet(deadDate, LocalDate::now));
    }

    private int getPeriod(LocalDate birthDate, LocalDate deadDate){
            Period diff = Period.between(birthDate, deadDate);
            return diff.getYears();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sd = new StringBuilder();
        sd.append("id: ");
        sd.append(id);
        sd.append(", Имя: ");
        sd.append(name);
        sd.append(", Пол: ");
        sd.append(getGender());
        sd.append(", Возраст: ");
        sd.append(getAge());
        return sd.toString();
    }
}

