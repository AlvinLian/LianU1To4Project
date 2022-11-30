import java.util.Scanner;
public class HangManRunner {
    public static void Main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Easy(e), medium(m), hard(h), or random(type nothing)?: ");
        String difficulty = input.nextLine();


        HangMan game1 = new HangMan(difficulty);

       while(game1.getLives() > 0 && game1.getSecretWordInQuestionMarks().contains("?")) {
           System.out.print("Enter a letter:");
           String guess = input.nextLine();
           game1.game(guess);
       }
       game1.determineResults();
    }
}
