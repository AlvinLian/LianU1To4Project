import java.util.Scanner;
public class HangManRunner {
    public static void Main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Easy(e), medium(m), or hard(h)?: ");
        String difficulty = input.nextLine();

        HangMan game = new HangMan(difficulty);
    }
}
