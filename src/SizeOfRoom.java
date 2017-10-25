import java.util.Scanner;
import java.lang.Math;

public class SizeOfRoom {

	static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {

		double length = 0;
		double width = 0;
		double height = 0;

		String continueRun = "0";

		System.out.println("Welcome to Grand Circus' Room Detail Generator!");

		while (!continueRun.equals("n") && !continueRun.equals("N")) {
			
			System.out.println();
			
			// Get length from user
			System.out.print("Enter Length: ");
			length = getMeasurement("Length");

			// Get width from user
			System.out.print("Enter Width: ");			
			width = getMeasurement("Width");

			// Get height from user
			System.out.print("Enter Height: ");
			height = getMeasurement("Height");

			calculateRoomSize(length, width, height);

			//Loop until user enters valid response to continue or end
			System.out.print("Continue? (y/n): ");
			while (!scnr.hasNext("[yYnN]")) {
				System.out.println("Invalid entry.");
				System.out.print("Continue? (y/n): ");
				scnr.next();
			}
			continueRun = scnr.next();
		}
		
		System.out.println("Program terminated.");

	}

	public static void calculateRoomSize(double length, double width, double height) {

		double area = 0;
		double perimeter = 0;
		double volume = 0;

		//Calculate sizes from given measurements
		area = length * width;
		perimeter = (2 * length) + (2 * width);
		volume = length * width * height;

		//Round solutions to readable numbers
		area = Math.round(area * 10);
		area = area / 10;

		perimeter = Math.round(perimeter * 10);
		perimeter = perimeter / 10;

		volume = Math.round(volume * 10);
		volume = volume / 10;

		//Output results
		System.out.println();
		System.out.println("Area: " + area);
		System.out.println("Perimeter: " + perimeter);
		System.out.println("Volume: " + volume);
		System.out.println();

	}

	public static double getMeasurement(String measureType) {
		
		double validDouble = 0;
		boolean valid = false;
		
		while (!valid) {
			
			//Check to see if input is not a number
			while (!scnr.hasNextDouble()) {
				System.out.println("Invalid entry. Enter a number greater than zero.");
				System.out.print("Enter " + measureType + ": ");
				scnr.next();
			}
			
			validDouble = scnr.nextDouble();
			
			//Check if input number is larger than zero
			if (validDouble > 0) {
				valid = true;
			} else {
				System.out.println("Invalid entry. Enter a number greater than zero.");
				System.out.print("Enter " + measureType + ": ");
			}
		}
		return validDouble;
	}

}
