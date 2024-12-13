package ru.GeekBrains.Voronyuk00.Family;

import java.io.IOException;

import ru.GeekBrains.Voronyuk00.Family.mvp.ConsoleUI;
import ru.GeekBrains.Voronyuk00.Family.mvp.View;

public class App {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Human person1  = new Human("Анна", "Воронюк",1971,7,29,Gender.female);
		Human person2 = new Human("Евгений","Воронюк",1967,5,9,Gender.male);
		Human person3 = new Human("Алексей","Воронюк",2000,4,12,Gender.male);
		Human person4 = new Human("Марина", "Воронюк",2000,10,5,Gender.female);
		Human person5 = new Human("Галина","Агафонова", 1940,8,14,2017,9,11,Gender.female);
		
		
		// Создание семейного дерева
		FamilyTree<Human> familyList = new FamilyTree<>();
		familyList.addElement(person1);
		familyList.addElement(person2);
		familyList.addElement(person3);
		familyList.addElement(person4);
		familyList.addElement(person5);
		
		
		person1.addChild(person3);
		person1.addChild(person4);
		person2.addChild(person3);
		person2.addChild(person4);
		
		person3.addFather(person1);
		person3.addMother(person2);
		person4.addFather(person1);
		person4.addMother(person2);
		person1.addMother(person5);
		
//		System.out.println(person5 + " Возраст " + person5.getAge());
		
		person5.addChild(person1);
		person5.showChildren();
		
//		System.out.println(familyList.searchPerson("Алексей","Воронюк"));
//		System.out.println(familyList.searchPerson("Иван","Высоцкий"));
//		System.out.println(familyList.getById(1));
		Writable fileHandler = new FileHandler();
		fileHandler.saveInFile(familyList);
		System.out.println(familyList);
		
		System.out.println("---------------------");
		
//		FamilyTree familyList2 = (FamilyTree) fileHandler.loadFromFile();
//		System.out.println(familyList2);
		
		// Урок 3 !!!!!!!!!!!
//		familyList.sortByName();
//		System.out.println(familyList);
//		
//		System.out.println("---------------------");
//		
//		familyList.sortByBirthDate();
//		System.out.println(familyList);
		
		// Урок 5 !!!!!!!!!!!!111111111111111111
		
		View view = new ConsoleUI();
		view.start();
		
	}
	

}
