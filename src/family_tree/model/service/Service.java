package family_tree.model.service;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Human;

public class Service {

    private FamilyTree<Human> group;

    public Service() {
        group = new FamilyTree<>();
    }

    public void add(String name, int age){
        ;
        Human human = new Human(name, age);
        group.add(human);
    }

    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список Членов семьи:\n");

//        Iterator<Student> iterator = group.iterator();
//        while (iterator.hasNext()){
//            Student student = iterator.next();
//            stringBuilder.append(student);
//            stringBuilder.append("\n");
//        }
        for (Human human: group){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        group.sortByName();
    }

    public void sortByAge(){
        group.sortByAge();
    }
}
