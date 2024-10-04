import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 5;  // You can change this for more/less attempts
        int rounds = 1;       // Number of rounds (optional)
        int score = 0;        // Player's score
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            // Generate a random number between 1 and 100
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + rounds + ": Guess the number between 1 and 100");

            // Loop for the number of allowed attempts
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                // Check if the guess is correct
                if (guess == randomNumber) {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the correct number.");
                    score++;
                } else if (guess < randomNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                // Display attempts left
                if (!guessedCorrectly && attempts < maxAttempts) {
                    System.out.println("You have " + (maxAttempts - attempts) + " attempts left.");
                }
            }

            // If the player didn't guess the correct number
            if (!guessedCorrectly) {
                System.out.println("You've run out of attempts. The correct number was: " + randomNumber);
            }

            // Ask if they want to play another round
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");

            if (playAgain) {
                rounds++;
            }
        }

        // Display final score and exit
        System.out.println("\nGame over! You won " + score + " out of " + rounds + " rounds.");
        System.out.println("Thanks for playing!");
        
        scanner.close();
    }
}
