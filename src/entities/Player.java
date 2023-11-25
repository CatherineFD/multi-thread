package entities;

public class Player {

    private boolean isAlive;
    private final String name;
    private Oracle oracle;

    public Player(String name, Oracle oracle) {
        this.name = name;
        this.isAlive = true;
        this.oracle = oracle;
    }

    public void initializeGUI() {
        // Initialize player's GUI (if any)
    }

    public void startTurn() {
        // Start the player's turn
    }

    public String makeGuess(int number) {
        boolean isNumberGuessed = oracle.isPlayerChoice(number);
        String message = "";

        if (isNumberGuessed) {
            message = "Игрок " + name + " выиграл!";
            System.out.println(oracle.playerWon());
            oracle.gameOver();
        } else {
            message = oracle.hintGenerator(number);
        }

        return message;
    }

    public boolean getAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}


//
//package entities;
//import java.util.Date;
//
//public class Player{
//
//    private boolean isAlive;
//    private final String name;
//    private Date timeGameFinal;
//
//    public Player(String name) {
//        this.name = name;
//        this.isAlive = true;
//    }
//
//    private void setTimeGameStart() {
//
//    }
//
//    public boolean getAlive() {
//        return this.isAlive;
//    }
//
//    public String getName(){
//        return this.name;
//    }
//
//    public void setAlive(boolean alive) {
//        this.isAlive = alive;
//    }
//
//}
