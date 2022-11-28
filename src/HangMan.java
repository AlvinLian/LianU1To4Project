public class HangMan {
    private String[] easyWords = {"cat", "mouse", "school"};
    private String[] mediumWords = {""};
    private String[] hardWords = {""};
    private String difficulty;
    private String secretWord;
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

    public void game() {
        while()
    }


}
