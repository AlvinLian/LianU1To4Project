/**
 *  This is a class that represents the Hangman game.
 */
public class Hangman {
    /** This is the list of easy words */
    private String[] easyWords = {"cat", "school", "mouse", "water", "house"};
    /** This is the list of medium difficulty words */
    private String[] mediumWords = {"suspense", "estimate", "prediction", "diversity", "alternative"};
    /** This is the list of hard words */
    private String[] hardWords = {"oblivious", "onomatopoeia", "omniscient", "enunciate", "acquaintance"};
    /** This is the difficulty of the Hangman game */
    private String difficulty = "";
    /** This is the secret word that the user has to guess */
    private String secretWord = "";
    /** This is the secret word converted to question marks */
    private String secretWordInQuestionMarks = "";
    /** This stores all the letters the users entered */
    private String lettersUsed = "Letters used: ";
    /** This is the number of attempts the user is given */
    private int lives = 5;

    /** Default constructor picks a random difficulty out of easy(e), medium(m), or hard(h) */
    public Hangman() {
        int randomDifficulty = (int)(Math.random() * 3);
        if(randomDifficulty == 0) {
            difficulty = "e";
        } else if (randomDifficulty == 1) {
            difficulty = "m";
        } else {
            difficulty = "h";
        }
    }
    /** One parameter constructor initializes difficulty to the difficulty the user chose except random
     @param difficulty easy(e), medium(m), or hard(h) game mode
     */
    public Hangman(String difficulty) {
        this.difficulty = difficulty;
    }

    /** returns the randomized difficulty
     @returns a string of e for easy, m for medium, or h for hard
     */
    public String toString() {
        return "The random difficulty is set to " + difficulty;
    }

    /** chooses a random word from a five word list depending on the selected difficulty */
    public void chooseWord() {
        int randomNum = (int)(Math.random() * 5);
        if(difficulty.equals("e")) {
            secretWord = easyWords[randomNum];
        } else if(difficulty.equals("m")) {
            secretWord = mediumWords[randomNum];
        } else {
            secretWord = hardWords[randomNum];
        }
    }

    /** converts the secret word to question marks and sets it to the instance variable secretWordInQuestionMarks */
    public void setSecretWordInQuestionMarks() {
        for(int i = 1; i <= secretWord.length(); i++) {
            secretWordInQuestionMarks += "?";
        }
    }

    /** checks if the game is still running or over
     @returns true if lives is greater than 0 and secretWordInQuestionMarks still contains question marks
     */
    public boolean isGameRunning() {
        boolean isGameRunning = getLives() > 0 && getSecretWordInQuestionMarks().contains("?");
        return isGameRunning;
    }

    /** handles the user's guesses. If guess is correct, question marks in secretWordInQuestionMarks gets replaced with
     the letter in the indexes necessary and displays a message that user guessed it right. Otherwise,
     a message tells the user they are wrong and lives is decremented by 1
     */
    public void game(String guess) {
        String newStr = "";
        if(secretWord.contains(guess)) {
            for(int index = 0; index < secretWord.length(); index++) {
                String letter = secretWord.substring(index, index + 1);
                if(guess.equals(letter)) {
                    newStr += letter;
                } else if (!(secretWordInQuestionMarks.substring(index, index + 1).equals("?"))) {
                    newStr += secretWord.substring(index, index + 1);
                } else {
                    newStr += "?";
                }
            }
            secretWordInQuestionMarks = newStr;
            System.out.println("You are correct!");
        } else {
            lives--;
            System.out.println("You are wrong! You have " + lives + " lives remaining.");
        }
    }

    /** appends the argument passed into the letter parameter and a comma to the lettersUsed instance variable
     @param letter the letter that the user entered
     @returns the String type instance variable called lettersUsed with the new letter added*/
    public String addLetterUsed(String letter) {
        if(lettersUsed.substring(14).contains(letter)) {
            return lettersUsed;
        }
        return lettersUsed += (letter + ", ");

    }

    /** returns the number of lives remaining
     @returns an integer from zero to five
     */
    public int getLives() {
        return lives;
    }

    /** returns the value assigned to the instance variable secretWordInQuestionMarks.
     @returns a String with question marks, letters, or a mixture of both
     */
    public String getSecretWordInQuestionMarks() {
        return secretWordInQuestionMarks;
    }

    /** prints the secret word and whether the user won or lost */
    public void determineResults() {
        System.out.println("The word was " + "\"" + secretWord + "\"");
        if(lives > 0) {
            System.out.println("You won!");
        } else {
            System.out.println("You lost.");
        }
    }


}

