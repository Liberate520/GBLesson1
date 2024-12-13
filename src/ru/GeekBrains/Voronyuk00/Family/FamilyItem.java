package ru.GeekBrains.Voronyuk00.Family;

import java.io.Serializable;
import java.time.LocalDate;

public interface FamilyItem<E> extends Serializable {
	
	public String getName();
	public String getSurname();
	////
	public void addMother(E h);
	public void addFather(E h);
	//////
	public E showMother();
	public E showFather();
	/////
	public LocalDate getdob();
	///
	public String showChildren();
	////
	public void setId(int id);
	public int getId();
	public void setSpouse(E h);
	public E getSpouse();
	
	
	
}
