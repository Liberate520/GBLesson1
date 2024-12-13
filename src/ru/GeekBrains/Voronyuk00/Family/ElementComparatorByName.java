package ru.GeekBrains.Voronyuk00.Family;

import java.util.Comparator;

public class ElementComparatorByName <E extends FamilyItem<E>> implements Comparator<E> {

	@Override
	public int compare(E o1, E o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}
	
}
