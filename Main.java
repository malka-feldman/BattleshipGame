/**
 * Malka Feldman
 * 1-4-2021
 */

package arraymethod;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//computer needs to populate the ship
		//display
	System.out.println("- - - - - - - - - - - - - - - ");
	System.out.println("  Welcome to Battleship!");
	System.out.println("- - - - - - - - - - - - - - - ");
	System.out.println();
	System.out.println("* You have 20 guesses."
	+ "\n" + "* For each geuss if you get a hit, you get a point for each ship you hit! "
	+ "\n" + "If you miss you lose a point.");
	Battleship battleship1 = new Battleship();
	battleship1.populate(1);
	//battleship1.display();
	Scanner input = new Scanner(System.in);
	int points = 0;
	for(int i=0; i<=10; i++) {
		System.out.println("Input a letter between a and j");
		String answer = input.nextLine();
		answer = answer.toUpperCase();
		char rowLabel = answer.charAt(0);
		while(rowLabel>75) {
			System.out.println("Sorry that letter is not part of our game.");
			System.out.println("Input a letter between a and j");
			String answer2 = input.nextLine();
			answer2 = answer2.toUpperCase();
			rowLabel = answer2.charAt(0);
		}
		System.out.println("Input a integer between 1 and 10");
		int column = input.nextInt();
		input.nextLine();
		while(column>10 || column<0) {
			System.out.println("Sorry that number is not part of our game.");
			System.out.println("Input a integer between 1 and 10");
			column = input.nextInt();
			input.nextLine();
		}
		if(battleship1.hit(rowLabel, column)) {
			System.out.println("Nice! You got a hit!");
			points++;
			System.out.println("You have " + points + " points!");
		}
		else {
			System.out.println("You missed:( Try again!");
			points--;
		}
		battleship1.displayNotes();
	}
	System.out.println("Good Game! You got " + points + " points!");
	}
}
