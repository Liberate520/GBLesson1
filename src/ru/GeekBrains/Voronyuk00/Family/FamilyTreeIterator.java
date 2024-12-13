package ru.GeekBrains.Voronyuk00.Family;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<E> implements Iterator<E>{

	private int familyId;
	private List<E> familyList;
	
	public FamilyTreeIterator(List<E> familyList) {
		this.familyList = familyList;
	}
	@Override
	public boolean hasNext() {
		return familyList.size() > familyId;
	}

	@Override
	public E next() {
		// TODO Auto-generated method stub
		return familyList.get(familyId++);
	}
	

}
