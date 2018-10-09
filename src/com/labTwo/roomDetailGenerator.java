package com.labTwo;

import java.util.Scanner;

public class roomDetailGenerator {

	public static void detailGenerator() {

		//I create an object of the Scanner class to receive user input.
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Welcome to Grand Circus' Room Detail Generator."
				+ "\nPlease enter the name of the room:");
		String name = scnr.nextLine();

		//I give the user a choice between metric and Imperial units.
		
		System.out.println("\nPlease choose between Metric or Imperial measurements"
				+ "\nFor metric enter M or for Imperial enter I:");
		char measurementChoice = scnr.next().charAt(0);
		
		//I allow the user to enter either an upper- or lower-case M/I, but no other value.
		
		switch (measurementChoice) {
		
			case 'M' | 'm':
				
				//If the user chooses metric, I receive and validate the input, making sure it is a positive number.
				
				System.out.println("\nEnter the length of the room in meters:");
				double lengthM = scnr.nextDouble();
					if (lengthM <= 0) {
						System.out.println("\nInvalid entry. Please restart the program.");
						System.exit(0);
					}
				
				System.out.println("\nNow enter the width:");
				double widthM = scnr.nextDouble();
					if (widthM <= 0) {
						System.out.println("\nInvalid entry. Please restart the program.");
						System.exit(0);
					}
						
				System.out.println("\nNow enter the height:");
				double heightM = scnr.nextDouble();
					if (heightM <= 0) {
						System.out.println("\nInvalid entry. Please restart the program.");
						System.exit(0);
					}
			
				//I calculate the metric results and print them to the screen.

				System.out.println("The perimeter of " + name + " is " + ((2 * lengthM) + (2 * widthM)) + " meters,"
						+"\nthe area is: " + (lengthM * widthM) + " square meters,"
						+ "\nand the volume is " + (lengthM * widthM * heightM) + " cubic meters.\n"
						+ "\nWould you like to continue? Y/N");

				char userOptionM = scnr.next().charAt(0);

				switch (userOptionM) {

					//I ask the user if they wish to continue and exit if they don't.
				
					case 'Y' | 'y':
						detailGenerator();
					break;

					case 'N' | 'n':
						System.out.println("\nHave a good day.");
						System.exit(0);
					break;
					
					default:
						System.out.println("\nInvalid entry. Please restart the program.");
						System.exit(0);
					break;
						

				}
				
			case 'I' | 'i':
				
				/*
				 * If the user chooses Imperial, I prompt the user to enter feet and inches.
				 * I validate the entries by making sure they are positive numbers.
				 * I further verify that the inch portion of each measurement is less than 12.
				 * The inch portion may include 0 as a valid entry.
				 * The inch portion allows a decimal number, whereas the feet portion does not.
				 */
				
				System.out.println("\nEnter the length of the room in feet and inches."
						+ "\nFeet:");
				int lengthFeet = scnr.nextInt();
					if (lengthFeet <= 0) {
						System.out.println("\nInvalid entry. Please restart the program.");
						System.exit(0);
					}
				
				System.out.println("Inches:");
				double lengthInches = scnr.nextInt();
					if (lengthInches < 0 | lengthInches >= 12) {
						System.out.println("\nInvalid entry. Please restart the program.");
						System.exit(0);
					}
					
				double totalLengthInches = (lengthFeet * 12 + lengthInches);
				
				
				System.out.println("\nNow enter the width in feet and inches."
						+ "\nFeet:");
				int widthFeet = scnr.nextInt();
					if (widthFeet <= 0) {
						System.out.println("\nInvalid entry. Please restart the program.");
						System.exit(0);
					}
					
				System.out.println("Inches:");
				double widthInches = scnr.nextInt();
					if (widthInches < 0 | widthInches >= 12) {
						System.out.println("\nInvalid entry. Please restart the program.");
						System.exit(0);
					}
				double totalWidthInches = (widthFeet * 12 + widthInches);
				
				
				System.out.println("\nNow enter the height in feet and inches."
						+ "\nFeet:");
				int heightFeet = scnr.nextInt();
					if (heightFeet <= 0) {
						System.out.println("\nInvalid entry. Please restart the program.");
						System.exit(0);
					}
					
				System.out.println("Inches:");
				double heightInches = scnr.nextInt();
					if (heightInches < 0 | heightInches >= 12) {
						System.out.println("\nInvalid entry. Please restart the program.");
						System.exit(0);
					}
				double totalHeightInches = (heightFeet * 12 + heightInches);
				
				//I calculate the room details in Imperial units and print them to the screen.
				
				double areaSquareInches = totalLengthInches * totalWidthInches;
				double perimeterInches = 2 * (totalLengthInches + totalWidthInches);
				double volumeCubicInches = totalLengthInches * totalWidthInches + totalHeightInches;
		
				double areaSquareFeet = areaSquareInches * 0.00694444444;
				double volumeCubicFeet = volumeCubicInches * 0.000578704;
				
				
				System.out.println("\nThe perimeter of " + name + " is "
						+ (perimeterInches/12) + " feet " + (perimeterInches % 12) + "inches,"
						+"\nthe area is " + areaSquareFeet + " square feet,"
						+"\nand the volume is " + volumeCubicFeet + " cubic feet."
						+ "\n\nWould you like to continue? Y/N");

				char userOption = scnr.next().charAt(0);

				switch (userOption) {

					//I ask the user if they wish to continue and exit if they don't.
				
					case 'Y' | 'y':
						detailGenerator();
					break;

					case 'N' | 'n':
						System.out.println("\nHave a good day.");
						System.exit(0);
					break;
					
					default:
						System.out.println("\nInvalid Entry. Please restart the program.");
					break;

				}
		
			default:
				System.out.println("\nInvalid Entry. Please restart the program.");
			break;
				
		}

		//I close the scanner to avoid a resource leak.
		
		scnr.close();

	}

	public static void main(String[] args) {

		detailGenerator();

	}

}
