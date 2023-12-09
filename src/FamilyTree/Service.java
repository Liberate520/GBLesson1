package FamilyTree;
import FamilyTree.HR.Human;
import FamilyTree.Family_Tree.FamilyTree;

public class Service {
    private FamilyTree group;
    private Human human;
//    public Service(){
//        group = new FamilyTree();
//        builder = new HumanBuilder();
//    }
//
//    public void addStudent(String name, int age){
//        Human human = new Human(name);
//        group.addHuman(human);
//    }

    public String getStudentListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей:\n");
        for (Human human: group){

//        Iterator<Student> iterator = group.iterator();
//        while (iterator.hasNext()){
//            Student human = iterator.next();
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public void sortByName(){
        group.sortByName();
    }
//    public void sortByAge(){
//        group.sortByAge();
//    }
}
