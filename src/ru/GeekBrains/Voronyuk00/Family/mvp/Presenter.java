package ru.GeekBrains.Voronyuk00.Family.mvp;
import  ru.GeekBrains.Voronyuk00.Family.Gender;

public class Presenter {
	
	private View view;
	private Service service;
	
	public Presenter(View view) {
		this.view = view;
		this.service = new Service();
	}

	public void addPerson1(String name, String surname, String dob, String dod,Gender gender) {
		// TODO Auto-generated method stub
		String[] dobElements = dob.split("\\.");
		String[] dodElements = dob.split("\\.");
		
		int year1 = Integer.parseInt(dobElements[0]);
		int month1 = Integer.parseInt(dobElements[1]);
		int day1 = Integer.parseInt(dobElements[2]);
		int year2 = Integer.parseInt(dodElements[0]);
		int month2 = Integer.parseInt(dodElements[1]);
		int day2 = Integer.parseInt(dodElements[2]);
		
		service.addPerson1(name, surname, year1, month1,day1,year2,month2,day2,gender);
		getFamilyList();
	}
	
	public void addPerson2(String name, String surname, String dob,Gender gender) {
		// TODO Auto-generated method stub
		String[] dobElements = dob.split("\\.");
		
		int year1 = Integer.parseInt(dobElements[0]);
		int month1 = Integer.parseInt(dobElements[1]);
		int day1 = Integer.parseInt(dobElements[2]);
		
		service.addPerson2(name, surname, year1, month1,day1,gender);
		getFamilyList();
	}

	public void getFamilyList() {
		
		String familyList = service.getFamilyList();
		view.printAnswer(familyList);
		
	}

	public void sortByName() {
		service.sortByName();
		getFamilyList();
	}
	
	public void sortByBirthDate() {
		service.sortByBirthDate();
		getFamilyList();
	}
}
