package controller;

import model.error_GameModel;
import java.util.*;
public class error_GameController implements Runnable {
    private error_GameModel model;
    private String playerName;

    public error_GameController(error_GameModel model, String playerName) {
        this.model = model;
        this.playerName = playerName;
    }

    public synchronized void run() {
        int guessNumber;
        int comparisonNumber = 100;
        String resultCompare = "";

        while (comparisonNumber != 0) {
            System.out.println("the player " + this.playerName + " enters a number:" );
            guessNumber = inputNumberByPlayer();
            comparisonNumber = model.isNumberGuessed(guessNumber);
            resultCompare = hintGenerator(comparisonNumber);
            System.out.println(playerName + " guessed " + guessNumber + ": " + (comparisonNumber == 0 ? "Correct" : "Incorrect") + "\n" +resultCompare);

            try {
                Thread.sleep(1000); // Ожидание 1 секунду, прежде чем сгенерировать новое число
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int inputNumberByPlayer() {
        Scanner scanner = new Scanner(System.in);
        int numberByPlayer;

        while (true) {
            if (scanner.hasNextInt()) {
                numberByPlayer = scanner.nextInt();
                break;
            } else {
                System.out.println("Это не число, попробуй еще раз.");
                scanner.next();
            }
        }

        return numberByPlayer;
    }

    private String hintGenerator (int number) {
        String resultCompare = "";
        if (number > 0) {
            resultCompare = "Вы ввели слишком маленькое число";
        } else if (number < 0){
            resultCompare = "Вы ввели слишком большое число";
        } else {
            resultCompare = "Вы угадали";
        }

        return resultCompare;
    }
}
