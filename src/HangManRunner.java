import java.util.Scanner;
public class HangManRunner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Easy(e), medium(m), hard(h), or random(r)?: ");
        String difficulty = input.nextLine();

        if(difficulty.equals("r")) {
            HangMan game1 = new HangMan();
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
            HangMan game1 = new HangMan(difficulty);
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
        }

    }
}
