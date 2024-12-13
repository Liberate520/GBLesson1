package ru.GeekBrains.Voronyuk00.Family;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
/**
 * Класс для создания человека
 */
public class Human implements Serializable,FamilyItem<Human>, Comparable<Human>{
	
	private int id;
	private String name;
	private String surname;
	private LocalDate dob, dod;
	private Gender gender;
	private List<Human> children;
	private Human father, mother;
	private Human spouse;
	/**
	 * Конструктор для создания человека
	 * @param name - имя человека
	 * @param surname - фамилия человека
	 * @param year - год рождения человека
	 * @param month - месяц рождения человека
	 * @param day - день рождения человека
	 * @param gender - пол человека
	 */
	public Human(String name, String surname, int year, int month,int day,Gender gender){
		this.name = name;
		this.surname = surname;
		this.dob = LocalDate.of(year, month, day);
		this.gender = gender;
		children = new ArrayList<>();
		this.id = -1;
	}
	/**
	 * Конструктор для создания человека
	 * @param name - имя человека
	 * @param surname - фамилия человека
	 * @param year - год рождения человека
	 * @param month - месяц рождения человека
	 * @param day - день рождения человека
	   @param year2 - год смерти человека
	 * @param month2 - месяц смерти человека
	 * @param day2 - день смерти человека
	 * @param gender - пол человека
	 */
	public Human(String name, String surname, int year, int month,int day,int year2, int month2, int day2,Gender gender){
		this(name,surname, year, month,day,gender);
		this.dod = LocalDate.of(year2, month2, day2);
	}
	
	/**
	 * Метод для получения имени
	 * @return имя
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Метод для получения фамилии
	 * @return фамилия
	 */
	public String getSurname() {
		return this.surname;
	}
	
	/**
	 * Добавление матери человека
	 * @param h - мать человека
	 */
	public void addMother(Human h) {
		if(mother == null) {
			this.mother = h;
		}
	}
	/**
	 * Добавление отца человека
	 * @param h - отец человека
	 */
	public void addFather(Human h) {
		if(father == null) {
			this.father = h;
		}
	}
	/**
	 * Метод для вывода матери человека
	 * @return мать человека
	 */
	public Human showMother() {
		return this.mother;
	}
	/**
	 * Метод для вывода отца человека
	 * @return отец человека
	 */
	public Human showFather() {
		return this.mother;
	}
	
	@Override
	public LocalDate getdob() {
		return this.dob;
	}
	/**
	 * Метод для получения возраста
	 * @return возраст
	 */
	public int getAge() {
		if(dod == null) {
			return Period.between(this.dob, LocalDate.now()).getYears(); 
		}
		else {
			return Period.between(dob, dod).getYears();
		}
	}
	
	public Gender getGender() {
		return this.gender;
	}
	
	/**
	 * Метод для добавления ребенка
	 * @param child - добавляемый ребёнок
	 */
	public boolean addChild(Human child) {
		if(!children.contains(child)) {
			children.add(child);
			return true;
		}
		return false;
		
	}
	/**
	 * Метод для демонстрации детей
	 */
	public String showChildren() {
		StringBuilder txt = new StringBuilder();
		boolean hasChildren = false;
		
		for(Human h : children) {
			txt.append(h);
			txt.append("\n");
			hasChildren = true;
		}
		
		if(hasChildren) {
			return txt.toString();
		}
		else return null ;
		
	}
	@Override
	public String toString() {
		return "Id: " + this.id +" Имя = " + name + ", фамилия = " + surname + ", дата рождения = " + dob  + ", пол = " + gender ;
		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj == this) {
			return true;
		}
		if(!(obj instanceof Human)) {
			return false;
		}
		Human human = (Human) obj;
		return human.getId() == getId();
	}
	
	public int getId() {
		return this.id;
	}

	public void setSpouse(Human h) {
		if(spouse == null) {
			this.spouse = h;
		}
	}
	
	public Human getSpouse() {
		return this.spouse;
	}
	@Override
	public int compareTo(Human o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.getName());
	}
	
	
		
}
