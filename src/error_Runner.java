import controller.error_GameController;
import model.error_GameModel;

public class error_Runner {
    public static final int PLAYER_NUMBER = 4;

    public error_Runner() {
    }
    public static void main(String[] args) {
        error_GameModel model = new error_GameModel();

        Thread[] players = new Thread[error_Runner.PLAYER_NUMBER];

        for (int i = 0; i < error_Runner.PLAYER_NUMBER; i++) {
            error_GameController playes = new error_GameController(model,"Player" + (i+1));
            Thread thread = new Thread(playes);
            players[i] = thread;
        }

        for (Thread player: players) {
            player.start();
        }

        for(Thread player: players) {
            try {
                player.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}