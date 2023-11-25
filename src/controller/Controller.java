package controller;
import model.Model;
import view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller{
    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public void startGame() {

        model.setGameStarted(true);
        while (model.isGameStarted()) {
            if (model.getCurrentPlayer().getAlive()) {

            } else {
                System.out.println("Game over");
                break;
            }
        }
    }

    public void getAllNumber() {
        model.getOracle().mixAllNumber();
    }

    public void checkNumber(int value) {
        model.checkNumber(value);
    }
}