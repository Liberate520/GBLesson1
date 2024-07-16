package ru.gb.vending_machine.family_tree.model;


import java.io.Serial;
import java.io.Serializable;
import java.util.*;

public class FamilyTree<T> implements Serializable, Iterable<T> {
    @Serial
    private static final long serialVersionUID = 1L;

    private final Map<String, T> members;

    public FamilyTree() {
        this.members = new HashMap<>();
    }

    public void addMember(String name, T member) {
        members.put(name, member);
    }

    public T getMember(String name) {
        return members.get(name);
    }

    @Override
    public Iterator<T> iterator() {
        return members.values().iterator();
    }

    public List<T> getAllMembers() {
        return new ArrayList<>(members.values());
    }

    public List<T> getMembersSortedByName(Comparator<T> nameComparator) {
        List<T> sortedMembers = getAllMembers();
        sortedMembers.sort(nameComparator);
        return sortedMembers;
    }

    public List<T> getMembersSortedByBirthDate(Comparator<T> birthDateComparator) {
        List<T> sortedMembers = getAllMembers();
        sortedMembers.sort(birthDateComparator);
        return sortedMembers;
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "members=" + members.values() +
                '}';
    }
}




