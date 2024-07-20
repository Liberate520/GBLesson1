import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenealogicalTree {
    private Map<String, Person> people;

    public GenealogicalTree() {
        people = new HashMap<>();
    }

    public void addPerson(Person person) {
        if (people.containsKey(person.getName())) {
            throw new IllegalArgumentException("Человек с именем " + person.getName() + " уже существует.");
        }
        people.put(person.getName(), person);
    }

    public void addRelationship(String parentName, String childName) {
        Person parent = people.get(parentName);
        Person child = people.get(childName);

        if (parent == null || child == null) {
            throw new IllegalArgumentException("Родитель или ребенок не найдены в дереве.");
        }

        parent.addChild(child);
    }

    public void addMarriage(String person1Name, String person2Name) {
        Person person1 = people.get(person1Name);
        Person person2 = people.get(person2Name);

        if (person1 == null || person2 == null) {
            throw new IllegalArgumentException("Один или оба человека не найдены в дереве.");
        }

        person1.setSpouse(person2);
        person2.setSpouse(person1);
    }

    public List<Person> getChildren(String personName) {
        Person person = people.get(personName);
        if (person == null) {
            throw new IllegalArgumentException("Человек с именем " + personName + " не найден.");
        }

        return person.getChildren();
    }

    public Person getPerson(String personName) {
        Person person = people.get(personName);
        if (person == null) {
            throw new IllegalArgumentException("Человек с именем " + personName + " не найден.");
        }

        return person;
    }
}
