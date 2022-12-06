import java.util.Scanner;
public class HangmanRunner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Easy(e), medium(m), hard(h), or random(r)?: ");
        String difficulty = input.nextLine();

        if(difficulty.equals("r")) {
            Hangman game1 = new Hangman();
            System.out.println(game1.toString());
            game1.chooseWord();
            game1.setSecretWordInQuestionMarks();

            while(game1.isGameRunning()) {
                System.out.println(game1.getSecretWordInQuestionMarks());
                System.out.print("Enter a letter: ");
                String guess = input.nextLine();
                System.out.println(game1.addLetterUsed(guess));
                game1.game(guess);
                System.out.println();
            }
            game1.determineResults();
        } else {
            Hangman game2 = new Hangman(difficulty);
            game2.chooseWord();
            game2.setSecretWordInQuestionMarks();

            while(game2.isGameRunning()) {
                System.out.println(game2.getSecretWordInQuestionMarks());
                System.out.print("Enter a letter: ");
                String guess = input.nextLine();
                System.out.println(game2.addLetterUsed(guess));
                game2.game(guess);
                System.out.println();
            }
            game2.determineResults();
        }

    }
}
