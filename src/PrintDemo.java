/**
 * Allison Snipes
 * Course 605.201.81 Summer 2020
 * Assignment 11 Question 2
 * 
 *  Project Specs:
 *  Write a program that uses a LinkedList object to store a list of print jobs in a FIFO queue. We will 
 *  assume that each job has a unique job number that is assigned sequentially, and that the print time 
 *  is randomly distributed between 10 seconds and 1000 seconds. These two data elements should be defined
 *  as part of a Job class. The program should prompt the user to either add a job to the queue or to quit.
 *  When a user adds a job, the program assigns a job number and randomly generates a print time for the 
 *  job. When the user quits, the program will display the jobs (i.e., the job id and print time) in the 
 *  queue, in the order in which they were added.
 *  
 *  @author Allison Snipes
 *  @version 1.0 
 */

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class PrintDemo {
	

	public static void main(String[] args) {
		headerMsg();
		LinkedList printJob = new LinkedList();
		int pNum = 0;
		int printTime;
		int choice;
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.println("What would you like to do?");
			System.out.println("1: add a job");
			System.out.println("0: quit the code\n");
			choice = input.nextInt();
			
			switch(choice) {
			case 0:
				System.out.println(printJob);
				System.out.println("Added job " + pNum + " to the Print Queue.\n");
				break;
				
			case 1:
				printTime = nextInt();
				pNum = pNum + 1;
				printJob.add("\nJob# : " + pNum + ", PrintTime: " + printTime);
				System.out.println("Added job " + pNum + " to the Print Queue.\n");
				break;
			}
			
		} while(choice != 0);
		
	}
	
	public static int nextInt() {
		long rnSeed = 0;
		Random rnGenerator = new Random(rnSeed); // creates a Random object 
		int printTime = rnGenerator.nextInt( 1000 ) + 10; // next int in range 10-1000
		return printTime;
	}
	
	private static void headerMsg() {
		System.out.println("\n");
		System.out.println("+----------------------------------------------------------------------------+");
		System.out.println("|                                Welcome User,                               |");
		System.out.println("|  This application uses a LinkedList object to store a list of print jobs   |");
		System.out.println("|  in a FIFO queue. Each job will be listed in order and the print time is   |");
		System.out.println("| randomly chosen. You may either choose to add a print job or either to     |");
		System.out.println("|                        quit the program. Let's start!                      |");
		System.out.println("+----------------------------------------------------------------------------+");
		System.out.println("\n");
	}


}
