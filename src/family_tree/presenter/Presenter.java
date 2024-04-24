package family_tree.presenter;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.service.Service;
import family_tree.view.View;


public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, int age) {
        service.add(name, age);
        //какой-то ответ
        getHumansListInfo();
    }

    public void getHumansListInfo() {
        String info = service.getHumanInfo();
        view.printAnswer(info);
    }

    public void sortByAge() {
        service.sortByAge();
        getHumansListInfo();
    }

    public void sortByName() {
        service.sortByName();
        getHumansListInfo();
    }
}
