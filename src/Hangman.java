public class Hangman {
    private String[] easyWords = {"cat", "school", "mouse", "water", "house"};
    private String[] mediumWords = {"suspense", "estimate", "prediction", "diversity", "alternative"};
    private String[] hardWords = {"oblivious", "onomatopoeia", "omniscient", "enunciate", "acquaintance"};
    private String difficulty = "";
    private String secretWord = "";
    private String secretWordInQuestionMarks = "";
    private String lettersUsed = "Letters used: ";
    private int lives = 5;

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
    public Hangman(String difficulty) {
        this.difficulty = difficulty;
    }

    public String toString() {
        return "The random difficulty is set towin  " + difficulty;
    }

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

    public void setSecretWordInQuestionMarks() {
        for(int i = 1; i <= secretWord.length(); i++) {
            secretWordInQuestionMarks += "?";
        }
    }

    public boolean isGameRunning() {
        boolean isGameRunning = getLives() > 0 && getSecretWordInQuestionMarks().contains("?");
        return isGameRunning;
    }
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

    public String addLetterUsed(String letter) {
        if(lettersUsed.substring(14).contains(letter)) {
            return lettersUsed;
        }
        return lettersUsed += (letter + ", ");

    }


    public int getLives() {
        return lives;
    }

    public String getSecretWordInQuestionMarks() {
        return secretWordInQuestionMarks;
    }

    public void determineResults() {
        System.out.println("The word was " + "\"" + secretWord + "\"");
        if(lives > 0) {
            System.out.println("You won!");
        } else {
            System.out.println("You lost.");
        }
    }


}

