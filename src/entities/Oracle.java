package entities;

import java.util.Random;

public class Oracle {

    private final int hiddenNumber;
    private int[][] allNumberArray;

    private static Random rand = new Random();

    public Oracle() {
        this.hiddenNumber = generateHiddenNumber();
        this.allNumberArray = generateAllNumber();
    }

    public int generateHiddenNumber() {
        return rand.nextInt(100) + 1;
    }

    public int[][] generateAllNumber() {
        int[][] array = new int[6][6];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                array[i][j] = rand.nextInt(100) + 1;
            }
        }

        int index = rand.nextInt(array.length);
        array[index][index] = this.hiddenNumber;
        return array;
    }

    public boolean isPlayerChoice(int number) {
        return hiddenNumber - number == 0;
    }

    public int getHiddenNumber() {
        return hiddenNumber;
    }

    public int[][] getAllNumberArray() {
        return allNumberArray;
    }

    public void mixAllNumber() {
        this.allNumberArray = generateAllNumber();
    }

    public String playerWon() {
        return "Вы угадали! Правильное число - " + hiddenNumber;
    }

    public void gameOver() {
        // Additional game-over logic if needed
    }

    public String hintGenerator(int number) {
        String resultCompare = "";
        if (number > hiddenNumber) {
            resultCompare = number + " слишком большое число";
        } else if (number < hiddenNumber){
            resultCompare = number + " слишком маленькое число";
        }

        return resultCompare;
    }
}

//package entities;
//
//import java.util.*;
//
//public class Oracle {
//
//    private final int hiddenNumber;
//    private int[][] allNumberArray;
//
//    private static Random rand = new Random();
//
//    public Oracle() {
//        this.hiddenNumber = this.generateHiddenNumber();
//        this.allNumberArray = this.generateAllNumber();
//    }
//
//    public int generateHiddenNumber() {
//        int hiddenNumber = rand.nextInt(100) + 1;
//        return hiddenNumber;
//    }
//
//    public int[][] generateAllNumber() {
//        int[][] array = new int[6][6];
//
//        for (int i = 0; i < 6; i++){
//            for (int j = 0; j < 6; j++){
//                array[i][j] = rand.nextInt(100) + 1;
//            }
//        }
//
//        int index = rand.nextInt(array.length);
//        array[index][index] = this.hiddenNumber;
//        return array;
//    }
//
//    public boolean isPlayerChoice(int number) {
//        boolean isNumberGuessed = false;
//        if (this.hiddenNumber - number == 0) {
//            isNumberGuessed = true;
//        }
//        return isNumberGuessed;
//    }
//
//    public String hintGenerator(int number) {
//        String resultCompare = "";
//        if (number > hiddenNumber) {
//            resultCompare = number + " слишком большое.";
//        } else if (number < hiddenNumber){
//            resultCompare = number + " слишком маленькое.";
//        }
//
//        return resultCompare;
//    }
//
//    public int getHiddenNumber() {
//        return this.hiddenNumber;
//    }
//
//    public int[][] getAllNumberArray() {
//        return allNumberArray;
//    }
//
//    public void mixAllNumber() {
//        this.allNumberArray = this.generateAllNumber();
//    }
//
//    public String playerWon() {
//        String answerToPlay = "";
//        answerToPlay = "Вы угадали! Праивльное число - " + this.hiddenNumber;
//
//        return answerToPlay;
//    }
//
//    public void gameOver() {
//
//    }
//}
