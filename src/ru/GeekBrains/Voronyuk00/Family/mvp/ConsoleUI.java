package ru.GeekBrains.Voronyuk00.Family.mvp;

import java.util.Scanner;
import ru.GeekBrains.Voronyuk00.Family.Gender;
import ru.GeekBrains.Voronyuk00.Family.mvp.Commands.MainMenu;
/**
 * Класс для взаимодействия с пользователем
 */
public class ConsoleUI implements View{
	
	private Presenter presenter;
	private Scanner scan;
	private boolean work;
	private MainMenu mainMenu;
	
	public ConsoleUI() {
		this.presenter = new Presenter(this);
		this.scan = new Scanner(System.in);
		this.work = true;
		this.mainMenu = new MainMenu(this);
	}

	@Override
	public void start() {
		System.out.println("Добро пожаловать в программу!!!");
		while(work) {
			System.out.print(mainMenu.menu());
			int choice = Integer.parseInt(scan.nextLine());
			mainMenu.execute(choice);
		}		
	}
	
	

	/**
	 * Метод добавления члена семьи
	 */
	public void addPerson() {
		// TODO Auto-generated method stub
		System.out.println("Ввидите имя: ");
		String name = scan.nextLine();
		System.out.println("Ввидите фамилию: ");
		String surname = scan.nextLine();
		System.out.println("Ввидите дату рождения формата гггг.м.д: ");
		String dob = scan.nextLine();
		System.out.println("Ввидите дату смерти формата гггг.м.д(если нет нажмите Enter): ");
		String dod = scan.nextLine();
		System.out.println("Введите пол: female, male");
		String genderStr = scan.nextLine().toLowerCase();
		
		if(dod != null) {
			if(genderStr.equals("male")) {
				presenter.addPerson1(name, surname, dob, dod, Gender.male);
			}
			else if(genderStr.equals("female")) {
				presenter.addPerson1(name, surname, dob, dod, Gender.female);
			}
			else {
				System.out.println("Неправильный пол");
			}
		}
		else {
			presenter.addPerson2(name, surname, dob, Gender.male);
		}
		
	}
	/*
	 * Метод для вывода списка студентов
	 */
	public void getFamilyList() {
		// TODO Auto-generated method stub
		presenter.getFamilyList();
	}
	
	public void sortByName() {
		presenter.sortByName();
	}
	
	public void sortByBirthDate() {
		presenter.sortByBirthDate();
	}

	@Override	public void printAnswer(String str) {
		System.out.println(str);	
	}
	
	public void exitProgram() {
		// TODO Auto-generated method stub
		work = false;
		System.out.println("Программа завершена");
	}

}
