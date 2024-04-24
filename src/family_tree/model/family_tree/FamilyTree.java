package family_tree.model.family_tree;

import family_tree.model.family_tree.iterators.FamilyTreeIter;
import family_tree.model.human.comparators.CompBD;
import family_tree.model.human.comparators.CompName;

import java.io.Serializable;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FamilyTree<E extends TreeN<E>> implements Serializable, Iterable<E> {
    private final List<E> humanList;
    private Writer writer;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public void add(E human) {
        if (human == null) {
            return;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);

            addToParents(human);
            addToChildren(human);
        }
    }

    private void addToParents(E human) {
        human.getParents();
    }

    private void addToChildren(E human) {
        human.getParents();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sbuilder = new StringBuilder();
        sbuilder.append("Сейчас в древе ");
        sbuilder.append(humanList.size());
        sbuilder.append(" объектов: \n");
        for (E human : humanList) {
            sbuilder.append(human);
            sbuilder.append("\n");
        }
        return sbuilder.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>) new FamilyTreeIter(humanList);
    }

    public void sortByName(){
        humanList.sort(new CompName<>());
    }

    public void sortByAge(){
        humanList.sort(new CompBD<>());
    }
}