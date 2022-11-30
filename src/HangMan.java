public class HangMan {
    private String[] easyWords = {"cat", "mouse", "school"};
    private String[] mediumWords = {""};
    private String[] hardWords = {""};
    private String difficulty;
    private String secretWord;
    private String secretWordInQuestionMarks;
    private int lives = 3;

    public HangMan() {
        int randomDifficulty = (int)(Math.random() + 3);
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
        int randomNum = (int)(Math.random() + 6);
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
    public void game(String letter) {
        System.out.println(secretWordInQuestionMarks);
        if(secretWord.contains(letter)) {
            for(int index = 0; index <= secretWord.length(); index++) {
                if(secretWord.substring(index, index + 1).equals("letter")) {
                    secretWordInQuestionMarks.replace(secretWord.substring(index, index+1), letter);
                }
            }
            System.out.println("You are correct!");
        } else {
            lives--;
            System.out.println("You are wrong! You have" + lives + "remaining.");
        }
    }

    public int getLives() {
        return lives;
    }

    public String getSecretWordInQuestionMarks() {
        return secretWordInQuestionMarks;
    }

    public void determineResults() {
        if(lives > 0) {
            System.out.println("You won!");
        } else {
            System.out.println("You lost.");
        }
    }


}
