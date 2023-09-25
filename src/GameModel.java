import java.util.Random;

public class GameModel {
    private final int randomNumber;
    private int currentPlayerIndex;

    public GameModel() {
        Random rand = new Random();
        randomNumber = rand.nextInt(100) + 1; // Генерация случайного числа от 1 до 100
        this.currentPlayerIndex = 0; // Индекс текущего игрока
    }

    public synchronized int isNumberGuessed(int number) {
        int comparisonNumber;
        comparisonNumber = this.randomNumber - number; // Проверка, является ли предложенное число правильным
        if (comparisonNumber != 0) {
            this.currentPlayerIndex = (this.currentPlayerIndex + 1) % 4; // Переключение на следующего игрока
        }
        return comparisonNumber;
    }

}
