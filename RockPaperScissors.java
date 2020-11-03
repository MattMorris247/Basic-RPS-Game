
/*
 * RockPaperScissors.java
 * Author:  Matt Morris  
 * Submission Date:  17 February 2020.
 *
 * Purpose: This program simulates a game of Rock Paper Scissors. The program asks the user for their choice, (the input) 
 * then matches it against a computer generated move to see who wins. Program uses a loop, that allows the user to the play
 * a set number winning matches to complete the game. 
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing 
 * or posting of source code for this assignment is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.  
 */
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		// VARIABLES\\
		int pointsToWin, highestScore = 0;

		int userScore = 0, compScore = 0;
		;
		String userMove, // the option the User chooses ( or "picks") .
				msg; // message to make it easier for final output.

		Scanner keyboard = new Scanner(System.in); // Creates the scanner object.
		boolean sendMsg = false; // this is the "please chose rock paper or scissors " msg

		System.out.print("Points to win:");
		pointsToWin = keyboard.nextInt();// ASSUME USER WILL INPUT VALID DIGIT .
		int number = pointsToWin ; 
		
		
		keyboard.nextLine();
		// BEGINNING OF WHILE
		while (highestScore < pointsToWin) { // highest score will be the higher score compared of the User Vs Computer.
			// COMPUTER MOVE
			String computerMove = ComputerOpponent.getMove(); // sets the Computer's move.

			System.out.print("Rock, paper, or scissors?");
			// USER MOVE -- CHECKS TO MAKE SURE IT IS VALID
			userMove = keyboard.nextLine().toLowerCase(); // Receives the user's pick. Converts it to LowerCase.
			if (userMove.equals("rock") || userMove.equals("paper") || userMove.equals("scissors")) {

				// WINNING FACTORS
				if (userMove.equals(computerMove)) { // TIE
					System.out.println("The computer chose " + computerMove + ", so it's a tie. (" + userScore + "-"
							+ compScore + ")");
				}
				// ROCK OVER SCISSORS - Winning
				else if (userMove.equals("rock") && computerMove.equals("scissors")) {
					userScore++; // Increase user score by 1.
					System.out.println("The computer chose " + computerMove + ", so you win! (" + userScore + "-"
							+ compScore + ")");
				}
				// ROCK OVER SCISSORS - Losing
				else if (computerMove.equals("rock") && userMove.equals("scissors")) {
					compScore++; // Increases computers' score by one.
					System.out.println("The computer chose " + computerMove + ", so you lose. (" + userScore + "-"
							+ compScore + ")");
				}
				// PAPER OVER ROCK- Win
				else if (userMove.equals("paper") && computerMove.equals("rock")) {
					userScore++;
					System.out.println("The computer chose " + computerMove + ", so you win! (" + userScore + "-"
							+ compScore + ")");
				}
				// PAPER OVER ROCK- Lose
				else if (computerMove.equals("paper") && userMove.equals("rock")) {
					compScore++;
					System.out.println("The computer chose " + computerMove + ", so you lose. (" + userScore + "-"
							+ compScore + ")");
				}
				// SCISSORS OVER PAPER - win
				else if (userMove.equals("scissors") && computerMove.equals("paper")) {
					userScore++;
					System.out.println("The computer chose " + computerMove + ", so you win! (" + userScore + "-"
							+ compScore + ")");
				}
				// SCISSORS OVER PAPER - lose
				else if (computerMove.equals("scissors") && userMove.equals("paper")) {
					compScore++;
					System.out.println("The computer chose " + computerMove + ", so you lose. (" + userScore + "-"
							+ compScore + ")");
				}
			}
			// This gets activated if user inputs invalid word...
			else {
				if (sendMsg = true) {
					System.out.println("Please chose 'rock', 'paper', or 'scissors' !");
				}

				if (sendMsg = false) {
					System.out.println("");
					sendMsg = true;
				}

			}

			// Deciding who has higher score. ( to deal with loop)
			if (userScore >= compScore) {
				highestScore = userScore;

			} else if (compScore >= userScore) {
				highestScore = compScore;
			}

		} // END OF WHILE LOOP

		if (userScore > compScore)
			msg = "Congratulations! You won!";
		else
			msg = "Sorry, you lost. Better luck next time !";
		System.out.println(msg);

		keyboard.close(); // closes Scanner for safety.
	} // END OF MAIN

}
