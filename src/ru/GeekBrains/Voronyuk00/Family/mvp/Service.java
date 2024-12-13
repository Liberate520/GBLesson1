package ru.GeekBrains.Voronyuk00.Family.mvp;
import ru.GeekBrains.Voronyuk00.Family.Human;

import java.time.LocalDate;

import ru.GeekBrains.Voronyuk00.Family.FamilyTree;
import ru.GeekBrains.Voronyuk00.Family.Gender;

public class Service {
	
	private FamilyTree<Human> familyList;
	
	public Service() {
		familyList = new FamilyTree<>();
	}
	
	public void addPerson1(String name, String surname, int year, int month,int day,int year2, int month2, int day2,Gender gender) {
		Human human = new Human(name, surname, year, month, day,year2, month2,day2, gender);
		familyList.addElement(human);
	}
	
	public void addPerson2(String name, String surname, int year, int month,int day,Gender gender) {
		Human human = new Human(name, surname, year, month, day, gender);
		familyList.addElement(human);
	}
	
	public String getFamilyList() {
		return familyList.toString();
	}
	
	public void sortByName() {
		familyList.sortByName();
	}
	
	public void sortByBirthDate() {
		familyList.sortByBirthDate();
	}
	
	public boolean addMother(int child,int mother) {
		if(familyList.showFamilyList().get(child).showMother() == null) {
			familyList.showFamilyList().get(child).addMother(familyList.showFamilyList().get(mother));
			return true;
		}
		return false;
	}
	
}
