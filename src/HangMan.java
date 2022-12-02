public class HangMan {
    private String[] easyWords = {"cat", "school", "mouse", "water", "house"};
    private String[] mediumWords = {"suspense", "estimate", "prediction", "diversity", "alternative"};
    private String[] hardWords = {"oblivious", "onomatopoeia", "omniscient", "enunciate", "acquaintance"};
    private String difficulty = "";
    private String secretWord = "";
    private String secretWordInQuestionMarks = "";
    private int lives = 3;

    public HangMan() {
        int randomDifficulty = (int)(Math.random() * 3);
        if(randomDifficulty == 0) {
            difficulty = "e";
        } else if (randomDifficulty == 1) {
            difficulty = "m";
        } else {
            difficulty = "h";
        }
    }
    public HangMan(String difficulty) {
        this.difficulty = difficulty;
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

    public int getLives() {
        return lives;
    }

    public String getSecretWordInQuestionMarks() {
        return secretWordInQuestionMarks;
    }

    public void determineResults() {
        System.out.println("The word was " + secretWord);
        if(lives > 0) {
            System.out.println("You won!");
        } else {
            System.out.println("You lost.");
        }
    }


}

