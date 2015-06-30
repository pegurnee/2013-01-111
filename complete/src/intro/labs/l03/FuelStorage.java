package intro.labs.l03;
/* The purpose of this program is to compute the total storage capacity of a fuel storage compound
 *
 * Coding provided by Eddie Gurnee
 * Version 0.0.1
 */

import java.util.Scanner;

public class FuelStorage {
	public static void main(String[] args) {
		int count = 0; // counter for loop
		int countCheck = 0; // counter for failchecks
		int numValues = 0; // limit for loop, used in stage 1 & 2
		int numTanks; // number of fuel tanks, used in stage 3
		double sum = 0.0; // sum of numbers and tanks, used in stage 2 & 3
		double yrdsCubed = 0.0; // total volume in cubic yards
		double volume, radius, height; // variables to compute volume, used in
										// stage 3
		int checkValid = 0; // checks if the inputted numbers were valid

		Scanner keyboard = new Scanner(System.in);

		// Stage 1:
		/*
		 * System.out.print("Enter upper limit for: "); numValues =
		 * keyboard.nextInt(); keyboard.nextLine(); System.out.println();
		 * 
		 * while (checkValid = false) {
		 * 
		 * if (numValues <= 0) {
		 * System.out.println("That is too low of a number. Try again.");
		 * System.out.println(); } else { checkValid = true; } }
		 * 
		 * while (count < numValues) { System.out.println(count + 1);
		 * 
		 * count = count + 1; }
		 */

		// Stage 2

		// Stage 3d

		System.out.print("Enter total number of fuel tanks: ");
		numTanks = keyboard.nextInt();
		keyboard.nextLine();
		System.out.println();

		while (count < numTanks) {
			System.out.println("Now enter some stats about the number "
								+ (count + 1) + " tank:");
			System.out.println();

			System.out.print("Height (greater than 0 ft, less than 20 ft): ");
			height = keyboard.nextDouble();
			keyboard.nextLine();

			if (height <= 0) {
				System.out.println("That value is too low.");
				while (checkValid < 1) {
					System.out.print("[Check " + (countCheck + 1)
										+ "] Input real Height (in feet): ");
					height = keyboard.nextDouble();
					keyboard.nextLine();

					if ((height > 0) && (height < 20)) {
						System.out.println("Thank you for a valid value.");
						checkValid = 1;
					} else {
						countCheck = countCheck + 1;
					}
					if (countCheck > 3) {
						System.out.println("Fail.");
						System.exit(0);
					}
				}
				checkValid = 0;
			}

			else if (height > 20) {
				System.out.println("That value is too high.");
				while (checkValid < 1) {
					System.out.print("[Check " + (countCheck + 1)
										+ "] Input real Height (in feet): ");
					height = keyboard.nextDouble();
					keyboard.nextLine();

					if ((height <= 20) && (height > 0)) {
						System.out.println("Thank you for a valid value.");
						checkValid = 1;
					} else {
						countCheck = countCheck + 1;
					}
					if (countCheck > 3) {
						System.out.println("Fail.");
						System.exit(0);
					}
				}
				checkValid = 0;
			}

			System.out.print("Radius (greater than 0 ft, less than 5 ft): ");
			radius = keyboard.nextDouble();
			keyboard.nextLine();

			if (radius <= 0) {
				System.out.println("That value is too low.");
				while (checkValid < 1) {
					System.out.print("[Check " + (countCheck + 1)
										+ "] Input real Radius (in feet): ");
					radius = keyboard.nextDouble();
					keyboard.nextLine();

					if ((radius > 0) && (radius <= 5)) {
						System.out.println("Thank you for a valid value.");
						checkValid = 1;
					} else {
						countCheck = countCheck + 1;
					}
					if (countCheck > 3) {
						System.out.println("Fail.");
						System.exit(0);
					}
				}
				checkValid = 0;
			}

			else if (radius > 5) {
				System.out.println("That value is too high.");
				while (checkValid < 1) {
					System.out.print("[Check " + (countCheck + 1)
										+ "] Input real Radius (in feet): ");
					radius = keyboard.nextDouble();
					keyboard.nextLine();

					if ((radius <= 5) && (radius > 0)) {
						System.out.println("Thank you for a valid value.");
						checkValid = 1;
					} else {
						countCheck = countCheck + 1;
					}
					if (countCheck > 3) {
						System.out.println("Fail.");
						System.exit(0);
					}
				}
				checkValid = 0;
			}
			System.out.println();

			volume = height * Math.PI * radius * radius;

			sum = sum + volume;

			count = count + 1;
		}

		yrdsCubed = sum / 27;
		System.out
				.println("The total storage available for fuel is approximately "
							+ yrdsCubed + " cubic yards.");

	}
}
