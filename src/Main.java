import java.util.List;

public class Main {
    public static void main(String[] args) {
        GenealogicalTree tree = new GenealogicalTree();

        // Создание людей
        Person peter = new Person("Пётр", "1970-01-01", "Male");
        Person evgenia = new Person("Евгения", "1975-02-02", "Female");
        Person anna = new Person("Анна", "2000-03-03", "Female");
        Person nikolay = new Person("Николай", "2005-04-04", "Male");
        Person alice = new Person("Алиса", "2007-05-05", "Female");
        Person ivan = new Person("Иван", "2010-06-06", "Male");
        Person alexey = new Person("Алексей", "2012-07-07", "Male");
        Person maria = new Person("Мария", "1978-09-09", "Female");
        Person andrey = new Person("Андрей", "1973-11-11", "Male");

        // Добавление людей в дерево
        tree.addPerson(peter);
        tree.addPerson(evgenia);
        tree.addPerson(anna);
        tree.addPerson(nikolay);
        tree.addPerson(alice);
        tree.addPerson(ivan);
        tree.addPerson(alexey);
        tree.addPerson(maria);
        tree.addPerson(andrey);

        // Установление родственных связей
        tree.addRelationship("Пётр", "Анна");
        tree.addRelationship("Евгения", "Анна");
        tree.addRelationship("Евгения", "Алиса");
        tree.addRelationship("Анна", "Иван");
        tree.addRelationship("Николай", "Алексей");

        // Установление супружеских пар
        tree.addMarriage("Пётр", "Евгения");
        tree.addMarriage("Анна", "Андрей");
        tree.addMarriage("Николай", "Мария");

        // Проведение исследования
        printFamily(tree, "Пётр");
        printFamily(tree, "Анна");
        printFamily(tree, "Николай");
    }

    private static void printFamily(GenealogicalTree tree, String parentName) {
        Person parent = tree.getPerson(parentName);
        Person spouse = parent.getSpouse();
        List<Person> children = tree.getChildren(parentName);

        System.out.print(parentName);
        if (spouse != null) {
            System.out.print(" и Супруг(а) " + spouse.getName());
        }
        System.out.print(" Дети: ");
        for (int i = 0; i < children.size(); i++) {
            System.out.print(children.get(i));
            if (i < children.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
