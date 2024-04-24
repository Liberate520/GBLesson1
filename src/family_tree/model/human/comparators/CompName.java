package family_tree.model.human.comparators;

import family_tree.model.family_tree.TreeN;

import java.util.Comparator;

public class CompName< T extends TreeN <T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) { return  o1.getName().compareTo(o2.getName()); }

}
