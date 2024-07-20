import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String birthDate;
    private String gender;
    private List<Person> children;
    private Person spouse;

    public Person(String name, String birthDate, String gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.children = new ArrayList<>();
        this.spouse = null;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public List<Person> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    @Override
    public String toString() {
        return name + " (" + gender + ", родился " + birthDate + ")";
    }
}
