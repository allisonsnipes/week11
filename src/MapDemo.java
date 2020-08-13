/**
 * Allison Snipes
 * Course 605.201.81 Summer 2020
 * Assignment 11 Question 1
 * 
 *  Project Specs:
 *  Write a program that uses one of the Map classes to implement a contact list. Contact information should include
 *  first name, last name, a phone number and an email address. The list should be stored on your computer’s file 
 *  system and entries sorted alphabetically according to a person’s last name. The program should prompt the user
 *  for the name of the file where the information is stored, and allow the user to add a contact from the list, 
 *  delete a contact from the list, and display the entire contact list.
 *  
 *  @author Allison Snipes
 *  @version 1.0 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeMap;

import com.sun.javafx.collections.MappingChange.Map;

public class MapDemo {

	public static void main(String[] args) {
		headerMsg();

		Scanner input = new Scanner(System.in);
		Contact contactTemp;
		String firstNameTemp;
		String lastNameTemp;
		String companyTemp;
		String phoneTemp;
		String emailTemp;
		String outfileTemp;
		int firstChoice, secondChoice;
		String line = null;

		TreeMap<String, String> allContacts = new TreeMap<String, String>();

		do {
			System.out.println("\n");
			System.out.println("+------------------------------------------------------+");
			System.out.println("|   If you would like to enter a contact press    (1)  |");
			System.out.println("|   If you would like to delete a contact press   (2)  |");
			System.out.println("| If you would like to display the contacts press (3)  |");
			System.out.println("|   If you would like to quit press               (4)  |");
			System.out.println("+------------------------------------------------------+");
			System.out.println("\n");

			firstChoice = input.nextInt();
	
			switch(firstChoice) {
			case 1:
				do {
					System.out.println("Enter the first name: \n");
					firstNameTemp = input.next();

					System.out.println("Enter the last name: \n");
					lastNameTemp = input.next();

					System.out.println("Enter the company: \n");
					companyTemp = input.next();

					System.out.println("Enter the phone number: \n");
					phoneTemp = input.next(); 

					System.out.println("Enter the email: \n");
					emailTemp = input.next();

					contactTemp = new Contact(firstNameTemp, lastNameTemp, companyTemp, phoneTemp, emailTemp);

					allContacts.put(contactTemp.getLastName(), contactTemp.toString());


					System.out.println(" Do you wish to add more contacts: Yes (1) or No (0)?");
					secondChoice = input.nextInt();

				} while (secondChoice != 0);

				break;

			case 2:
				do {
					System.out.println("Please enter a last name to delete a contact: \n");
					lastNameTemp = input.nextLine();

					if(allContacts.get(lastNameTemp) != null) {
						allContacts.remove(lastNameTemp);
						System.out.println("The contact is removed with the last name: " + allContacts.get(lastNameTemp) + ".");
					} else {
						System.out.println("An unknown error has occured " + allContacts.get(lastNameTemp) + " does not exists.");
					}

					System.out.println(" Do you wish to delete more contacts: Yes (1) or No (0)?");
					secondChoice = input.nextInt();
				} while (secondChoice != 0);

				break;


			case 3:
				System.out.println("------------------Directory----------------\n");
				for(String key: allContacts.keySet()) {
					System.out.println(allContacts.get(key));
				}
				break;

			case 4:
				System.out.println("Thank you for using the application.");
				break;

			default:
				System.out.println("An unknown error has occured. Please enter a number between 1-4.");
				break;
			}
			break;

		} while (firstChoice != 4);

		System.out.println("Enter the file name of the program:");
		String file = input.next();
		File f = new File(file);

		if(f.exists()){
			System.out.println( "File already exists. Program ending.");
			System.exit( 1 );
		} else {
			System.out.println( "New file being created." );
		}

		PrintWriter out = null;

		try {
			PrintWriter output = new PrintWriter(f);
			out = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			for(String key: allContacts.keySet()) {
				out.println(allContacts.get(key));
			}

		} catch (FileNotFoundException e) {
			System.out.println("There is an error:" + e.getMessage() + " .");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("There is an error PrintWriter not created:" + e.getMessage() + " .");
			e.printStackTrace();
		} finally {
			out.close();
		} 
	}



	private static void headerMsg() {
		System.out.println("\n");
		System.out.println("+------------------------------------------------------------------------------+");
		System.out.println("|                                   Welcome User,                              |");
		System.out.println("|      This application should allow the user to add a contact to the list,    |");
		System.out.println("|  delete a contact from the list, and display the entire contact list. The    |");
		System.out.println("| information should include a person's first name, last name, a phone number, |");
		System.out.println("|  and email address. You will be asked the name of the file to open it-- the  |");
		System.out.println("|   name is: directory.txt. All the prepopulated information is stored there.  |");
		System.out.println("|                                   Let's start!                               |");
		System.out.println("+------------------------------------------------------------------------------+");
		System.out.println("\n");
	}


}

class Contact {
	private String firstName, lastName, company, phone, email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Contact(String firstName, String lastName, String company, String phone, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.phone = phone;
		this.email = email;
	}

}



