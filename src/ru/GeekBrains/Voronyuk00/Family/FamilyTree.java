package ru.GeekBrains.Voronyuk00.Family;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/**
 * Класс для создания семейного дерева
 */
public class FamilyTree<T extends FamilyItem<T>> implements Serializable, Iterable<T>{
	
	private List<T> familyList;
	private int Id;
	/**
	 * Конструктор для создания семейного дерева
	 */
	public FamilyTree(){
		familyList = new ArrayList<>();
	}
	
	public void addElement(T h) {
		 if(!familyList.contains(h)) {
			familyList.add(h);
			h.setId(Id++);
		 }
			
	}
	
	public void setWidding(int id1, int id2) {
		
		if(checkId(id1) && checkId(id2)) {
			if(getById(id1).getSpouse() == null && getById(id2).getSpouse() == null) {
				getById(id1).setSpouse(getById(id2));
				getById(id2).setSpouse(getById(id2));
			}
		}else {
			return;
		}
	}
	
	public List<T> showFamilyList(){
		return familyList;
	}
	
	/**
	 * 
	 * @param name имя человека
	 * @param surname фамилия человека
	 * @return информация о человеке
	 */
	public T searchElement(String name, String surname) {
		for(T h : familyList) {
			if(h.getName().equalsIgnoreCase(name) && h.getSurname().equalsIgnoreCase(surname)) {
				return h;
			}
		}
		return null;
		
	}
	
	public T getById(int id) {
		for(T h : familyList) {
			if(h.getId() == id) {
				return h;
			}
		}
		return null;
	}
	
	private boolean checkId(int id) {
		return id>= 0 && id < Id;
	}
	
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj == this) {
			return true;
		}
		if(!((T)obj instanceof T)) {
			return false;
		}
		T human = (T) obj;
		return human.getId() != Id;
	}
	
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(T h : familyList) {
			str.append(h);
			str.append("\n");
		}
		return str.toString();
		
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new FamilyTreeIterator<>(familyList);
	}
	
	public void sortByName() {
		Collections.sort(familyList, new ElementComparatorByName<>());
	}
	
	public void sortByBirthDate() {
		Collections.sort(familyList ,new ElementComparatorByBirthDate<>());
	}
	
	
}
