public class Runner {
    public static final int PLAYER_NUMBER = 4;

    public Runner() {
    }
    public static void main(String[] args) {
        GameModel model = new GameModel();

        Thread[] players = new Thread[Runner.PLAYER_NUMBER];

        for (int i = 0; i < Runner.PLAYER_NUMBER; i++) {
            GameController playes = new GameController(model,"Player" + (i+1));
            Thread thread = new Thread(playes);
            players[i] = thread;
        }

        for (Thread player: players) {
            System.out.println("the player " + player + " enters a number:" );
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