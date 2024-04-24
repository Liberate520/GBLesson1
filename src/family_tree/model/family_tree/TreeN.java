package family_tree.model.family_tree;


import family_tree.model.human.Human;

import java.time.LocalDate;
import java.util.List;

public interface TreeN<H> {
    String getName();

    boolean addChild(Human human);

    int getAge();
    boolean addChild(H human);
    boolean addParent(H human);
    LocalDate getDob();
    LocalDate getDad();
    List<H> getChildren();
    List<H> getParents();
}


