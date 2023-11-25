package view;

import controller.Controller;
import model.*;
import setting.*;

import javax.swing.*;

public class View implements ModelObserver{
    private final JFrame frame;

    private final Controller controller;
    private final Model model;
    private final WindowCreator windowCreator;

    public View(Controller controller, Model model, WindowCreator windowCreator) {
        this.controller = controller;
        this.model = model;
        this.windowCreator = windowCreator;

        int[][] allNumberOracle = this.model.getOracle().getAllNumberArray();
        this.model.setObserver(this);

        this.frame = this.windowCreator.createMainWindow(controller, allNumberOracle);
    }

    public void displayResult(String result, int[][] allNumberOracle) {
        this.windowCreator.showMessage(result);
        this.windowCreator.updateButtonLabels(allNumberOracle);
    }

    @Override
    public void onModelChanged(String result, int[][] allNumberOracle) {
        this.displayResult(result, allNumberOracle);
    }

//    public void showMessage(String message) {
//        resultLabel.setText(message);  // Update the text of the resultLabel
//    }
//
//    public void updateButtonLabels() {
//        int[][] allNumberOracle = model.getOracle().getAllNumberArray();
//        for (int i = 0; i < numbers.size(); i++) {
//            numbers.get(i).setText(String.valueOf(allNumberOracle[i / Setting.COLS][i % Setting.COLS]));
//        }
//    }

//    public Model getModel() {
//        return model;
//    }
//
//    public void showMessage(String message) {
//        // ваш код для обновления текста resultLabel
//    }
//
//    public void updateButtonLabels() {
//        // ваш код для обновления текста кнопок
//    }
//
//    public Model getModel() {
//        return model;
//    }
}
//
//public class View {
//    private JFrame frame;
//    private JPanel panel;
//    private JButton[] buttons;
//    private List<JButton> numbers;
//    private JLabel resultLabel;  // New JLabel for displaying information
//    private final Controller controller;
//    private final Model model;
//
//    public View(Model model, Controller controller) {
//        this.controller = controller;
//        this.model = model;
//
//        frame = new JFrame(Setting.FRAME_TITLE);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(Setting.FRAME_WIDTH, Setting.FRAME_HEIGHT);
//        frame.setResizable(Setting.FRAME_RESIZABLE);
//
//        int[][] allNumberOracle = model.getOracle().getAllNumberArray();
//
//        panel = new JPanel();
//        buttons = new JButton[Setting.ROWS * Setting.COLS];
//        numbers = new ArrayList<>();
//
//        panel.setLayout(new GridLayout(Setting.ROWS, Setting.COLS));
//        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
//
//        this.createPanelButton(panel, buttons, numbers, allNumberOracle);
//
//        resultLabel = new JLabel();  // Initialize the JLabel
//        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        resultLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
//        frame.add(panel, BorderLayout.CENTER);
//        frame.add(resultLabel, BorderLayout.SOUTH);  // Add the JLabel to the bottom of the frame
//
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    private void createPanelButton(JPanel panel, JButton[] buttons, List<JButton> numbers, int[][] allNumberOracle) {
//        int helpVar;
//
//        for (int i = 0; i < Setting.ROWS; i++) {
//            for (int j = 0; j < Setting.COLS; j++) {
//                if (i == 0) {
//                    helpVar = 1;
//                } else {
//                    helpVar = i;
//                }
//
//                buttons[helpVar * j] = new JButton(String.valueOf(allNumberOracle[i][j]));
//                buttons[helpVar * j].setPreferredSize(new Dimension(Setting.BUTTON_WIDTH, Setting.BUTTON_HEIGHT));
//
//                ButtonListener listener = new ButtonListener(controller, this);
//                buttons[helpVar * j].addActionListener(listener);
//
//                panel.add(buttons[helpVar * j]);
//                numbers.add(buttons[helpVar * j]);
//            }
//        }
//    }
//public void showMessage(String message) {
//    resultLabel.setText(message);  // Update the text of the resultLabel
//}
//
//    public void updateButtonLabels() {
//        int[][] allNumberOracle = model.getOracle().getAllNumberArray();
//        for (int i = 0; i < numbers.size(); i++) {
//            numbers.get(i).setText(String.valueOf(allNumberOracle[i / Setting.COLS][i % Setting.COLS]));
//        }
//    }
//
//    public Model getModel() {
//        return model;
//    }

//}

// ... (your existing imports)

//
//public class View {
//    private JFrame frame;
//    private JPanel panel;
//    private JButton[] buttons;
//    private List<JButton> numbers;
//    private final Controller controller;
//    private final Model model;
//
//    public View(Model model, Controller controller) {
//        this.controller = controller;
//        this.model = model;
//
//        frame = new JFrame(Setting.FRAME_TITLE);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(Setting.FRAME_WIDTH, Setting.FRAME_HEIGHT);
//        frame.setResizable(Setting.FRAME_RESIZABLE);
//
//        int[][] allNumberOracle = model.getOracle().getAllNumberArray();
//
//        panel = new JPanel();
//        buttons = new JButton[Setting.ROWS * Setting.COLS];
//        numbers = new ArrayList<>();
//
//        panel.setLayout(new GridLayout(Setting.ROWS, Setting.COLS));
//
//        createPanelButton(panel, buttons, numbers, allNumberOracle);
//
//        frame.add(panel);
//
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    private void createPanelButton(JPanel panel, JButton[] buttons, List<JButton> numbers, int[][] allNumberOracle) {
//        int helpVar;
//
//        for (int i = 0; i < Setting.ROWS; i++) {
//            for (int j = 0; j < Setting.COLS; j++) {
//                if (i == 0) {
//                    helpVar = 1;
//                } else {
//                    helpVar = i;
//                }
//
//                buttons[helpVar * j] = new JButton(String.valueOf(allNumberOracle[i][j]));
//                buttons[helpVar * j].setPreferredSize(new Dimension(Setting.BUTTON_WIDTH, Setting.BUTTON_HEIGHT));
//
//                ButtonListener listener = new ButtonListener(controller, this);
//                buttons[helpVar * j].addActionListener(listener);
//
//                panel.add(buttons[helpVar * j]);
//                numbers.add(buttons[helpVar * j]);
//            }
//        }
//    }
//
//    public void showMessage(String message) {
//        JOptionPane.showMessageDialog(frame, message);
//    }
//
//    public Model getModel() {
//        return model;
//    }
//}

//package view;
//
//import controller.Controller;
//import model.Model;
//import entities.*;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import static java.lang.Integer.parseInt;
//
//public class View {
//    JFrame frame;
//    JPanel panel;
//    JButton[] buttons;
//    List<JButton> numbers;
//    public final int ROWS = 6;
//    public final int COLS = 6;
//    private static final int BUTTON_WIDTH = 50;
//    private static final int BUTTON_HEIGHT = 50;
//    private Controller controller;
//    private Model model;
//
//    public View(Model model, Controller controller) {
//
//        this.controller = controller;
//        this.model = model;
//
//        frame = new JFrame("Game Oracle");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(600, 400);
//        frame.setResizable(false);
//
//
//        int[][] allNumberOracle = model.getOracle().getAllNumberArray();
//
//        panel = new JPanel();
//        buttons = new JButton[36];
//        numbers = new ArrayList<JButton>();
//
//        panel.setLayout(new GridLayout(ROWS, COLS));
//
//        this.createPanelButton(panel, buttons, numbers, allNumberOracle);
//
//        frame.add(panel);
//
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    private void createPanelButton(JPanel panel, JButton[] buttons, List<JButton> numbers, int[][] allNumberOracle) {
//        int helpVar = 0;
//
//        for (int i=0; i < ROWS; i++){
//            for (int j = 0; j < COLS; j++) {
//
//                if (i == 0) {
//                    helpVar = 1;
//                } else {
//                    helpVar = i;
//                }
//                buttons[helpVar * j] = new JButton(String.valueOf(allNumberOracle[i][j]));
//                buttons[helpVar * j].setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
//
//                buttons[helpVar * j].addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        handleButtonClicked(e);
//                    }
//                });
//
//                panel.add(buttons[helpVar * j]);
//                numbers.add((JButton) buttons[helpVar * j]);
//            }
//        }
//    }
//
//    private void handleButtonClicked(ActionEvent e) {
//        JButton source = (JButton) e.getSource();
//        String result = controller.checkNumber(parseInt( source.getText()));
//        controller.getAllNumber();
//        this.showMessage(result);
//        System.out.println("Button " + model.getOracle().getHiddenNumber() + " clicked");
//    }
//
//    public void showMessage(String message) {
//        JOptionPane.showMessageDialog(frame, message);
//    }
//
//
//    public void displayResult(int userInput, int hiddenNumber, Player player) {
//        String resultMessage = "Congratulations! You guessed the number!";
//        if (userInput == hiddenNumber) {
//            JOptionPane.showMessageDialog(frame, resultMessage, "Game Over", JOptionPane.PLAIN_MESSAGE);
//            frame.dispose();
//        } else {
//            String wrongMessage = "Oops, the number you guessed was: " + userInput + ", but the actual number was: " + hiddenNumber + "!";
//            this.showMessage(wrongMessage);
//        }
//    }
//}
//
//
