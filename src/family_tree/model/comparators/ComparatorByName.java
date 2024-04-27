package family_tree.model.comparators;

import family_tree.model.subject.Subject;

import java.util.Comparator;

public class ComparatorByName<E extends Subject> implements Comparator<E> {
    public int compare(E o1, E o2) { return o1.getName().compareTo(o2.getName());}
}
