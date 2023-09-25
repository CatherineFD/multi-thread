import java.util.*;
public class GameController implements Runnable {
    private GameModel model;
    private String playerName;

    public GameController(GameModel model, String playerName) {
        this.model = model;
        this.playerName = playerName;
    }

    public void run() {
        int guessNumber;
        int comparisonNumber = 100;
        String resultCompare = "";

        while (comparisonNumber != 0) {
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
            resultCompare = "Вы ввели слишком МАЛЕНЬКОЕ число";
        } else {
            resultCompare = "Вы ввели слишком БОЛЬШОЕ число";
        }

        return resultCompare;
    }
}
