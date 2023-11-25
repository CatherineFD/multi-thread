package model;

import entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Model {

    private Player currentPlayer;
    private Oracle oracle;
    public boolean isGameStarted;
    private ModelObserver observer;


    public Model() {

        oracle = new Oracle();
        currentPlayer = new Player("Alice", oracle);
        this.isGameStarted = false;
    }

    public void setGameStarted(boolean started) {
        this.isGameStarted = started;
        if (!this.isGameStarted) {
            currentPlayer.setAlive(false);
        }
    }

    public boolean isGameStarted() {
        return this.isGameStarted;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }
    public Oracle getOracle() {
        return this.oracle;
    }

    public void checkNumber(int value) {
        String message = "";

        message = this.currentPlayer.makeGuess(value);
        int[][] allNumberOracle = this.getOracle().getAllNumberArray();
        this.notifyObserver(message, allNumberOracle);

    }

    public void setObserver(ModelObserver observer) {
        this.observer = observer;
    }

    private void notifyObserver(String result, int[][] allNumberOracle) {
        if (this.observer != null) {
            this.observer.onModelChanged(result, allNumberOracle);
        }
    }

//    public interface ModelListener {
//        void onResultChanged(String result, int[][] allNumberOracle);
//    }
//
//    private List<ModelListener> listeners = new ArrayList<>();
//
//    public void addListener(ModelListener listener) {
//        listeners.add(listener);
//    }
//
//    private void notifyListeners(String result, int[][] allNumberOracle) {
//        for (ModelListener listener : listeners) {
//            listener.onResultChanged(result, allNumberOracle);
//        }
//    }
}
