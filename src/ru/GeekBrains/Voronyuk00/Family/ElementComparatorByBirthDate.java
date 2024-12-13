package ru.GeekBrains.Voronyuk00.Family;

import java.util.Comparator;

public class ElementComparatorByBirthDate<E extends FamilyItem<E>> implements Comparator<E>{

	@Override
	public int compare(E o1, E o2) {
	
		return o1.getdob().compareTo(o2.getdob());
	}
	
}
