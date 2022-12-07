// calling the scanner class to read and receive user input
import java.util.Scanner;
public class HangmanRunner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // asking user for difficulty of their choice
        System.out.print("Easy(e), medium(m), hard(h), or random(r)?: ");
        String difficulty = input.nextLine();

        if(difficulty.equals("r")) {
            // game1 object is created if difficulty is set to r
            Hangman game1 = new Hangman();
            // prints the randomly selected difficulty
            System.out.println(game1.toString());
            game1.chooseWord();
            game1.setSecretWordInQuestionMarks();

            // repeatedly asks user to enter a letter until game1.isGameRunning is false.
            // methods are called to check if the letter entered is correct or not
            while(game1.isGameRunning()) {
                System.out.println(game1.getSecretWordInQuestionMarks());
                System.out.print("Enter a letter: ");
                String guess = input.nextLine();
                System.out.println(game1.addLetterUsed(guess));
                game1.game(guess);
                System.out.println();
            }
            //prints whether the user won or lost the game
            game1.determineResults();
        } else {
            // game2 object is created if difficulty is NOT set to r
            Hangman game2 = new Hangman(difficulty);
            game2.chooseWord();
            game2.setSecretWordInQuestionMarks();

            // repeatedly asks user to enter a letter until game2.isGameRunning is false.
            // methods are called to check if the letter entered is correct or not
            while(game2.isGameRunning()) {
                System.out.println(game2.getSecretWordInQuestionMarks());
                System.out.print("Enter a letter: ");
                String guess = input.nextLine();
                System.out.println(game2.addLetterUsed(guess));
                game2.game(guess);
                System.out.println();
            }
            //prints whether the user won or lost the game
            game2.determineResults();
        }

    }
}
