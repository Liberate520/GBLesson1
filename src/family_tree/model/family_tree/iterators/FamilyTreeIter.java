package family_tree.model.family_tree.iterators;

import family_tree.model.human.Human;


import java.util.Iterator;
import java.util.List;

public class FamilyTreeIter<E> implements Iterator<Human> {
    private List<E> humanList;
    private int index;


    public FamilyTreeIter(List<E> humanList) {
        this.humanList = humanList;
    }
    @Override
    public boolean hasNext() {
        return  index < humanList.size(); }

    @Override
    public Human next() {
        return (Human) humanList.get(index++);
    }
}
