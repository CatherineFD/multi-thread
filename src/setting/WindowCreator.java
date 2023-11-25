package setting;

import controller.Controller;
import listeners.ButtonListener;
import model.Model;
import view.View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class WindowCreator {

    private JFrame frame;
    private JPanel panel;
    private JButton[] buttons;
    private List<JButton> numbers;
    private JLabel resultLabel;

    private JTextField inputField; // Поле ввода
    private JLabel infoLabel;
    
    public JFrame createMainWindow(Controller controller, int[][] allNumberOracle) {
        this.frame = new JFrame(Setting.FRAME_TITLE);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(Setting.FRAME_WIDTH, Setting.FRAME_HEIGHT);
        this.frame.setResizable(Setting.FRAME_RESIZABLE);

        this.panel = new JPanel();
        this.buttons = new JButton[Setting.ROWS * Setting.COLS];
        this.numbers = new ArrayList<>();

        this.panel.setLayout(new GridLayout(Setting.ROWS, Setting.COLS));
        this.panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        this.createPanelButton(controller, allNumberOracle);

        JPanel inputPanel = createInputPanel(controller); // Создаем панель для ввода
        this.frame.add(inputPanel, BorderLayout.EAST); // Добавляем ее справа

        this.resultLabel = new JLabel();
        this.resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.resultLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.frame.add(panel, BorderLayout.CENTER);
        this.frame.add(resultLabel, BorderLayout.SOUTH);

        this.frame.pack();
        this.frame.setVisible(true);

        return this.frame;
    }

    private void createPanelButton(Controller controller, int[][] allNumberOracle) {
//        int[][] allNumberOracle = model.getOracle().getAllNumberArray();
        int helpVar;

        for (int i = 0; i < Setting.ROWS; i++) {
            for (int j = 0; j < Setting.COLS; j++) {
                if (i == 0) {
                    helpVar = 1;
                } else {
                    helpVar = i;
                }

                this.buttons[helpVar * j] = new JButton(String.valueOf(allNumberOracle[i][j]));
                this.buttons[helpVar * j].setPreferredSize(new Dimension(Setting.BUTTON_WIDTH, Setting.BUTTON_HEIGHT));

                ButtonListener listener = new ButtonListener(controller);
                this.buttons[helpVar * j].addActionListener(listener);

                this.panel.add(buttons[helpVar * j]);
                this.numbers.add(buttons[helpVar * j]);
            }
        }
    }

    private JPanel createInputPanel(Controller controller) {
        JPanel inputPanel = new JPanel();
        inputPanel.setPreferredSize(new Dimension(600, 200));
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(100, 200));
        inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Вызываем метод контроллера при нажатии Enter
                    controller.checkNumber(Integer.parseInt(inputField.getText()));
                    inputField.setText(""); // Очищаем поле ввода после отправки
                }
            }
        });

        infoLabel = new JLabel("Info: "); // Начальный текст для метки с информацией
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        inputPanel.add(inputField, BorderLayout.NORTH);
        inputPanel.add(infoLabel, BorderLayout.SOUTH);

        return inputPanel;
    }

    public void showMessage(String message) {
        this.resultLabel.setText(message);  // Update the text of the resultLabel
        System.out.println(message);
    }

    public void updateButtonLabels(int[][] allNumberOracle) {
        for (int i = 0; i < this.numbers.size(); i++) {
            this.numbers.get(i).setText(String.valueOf(allNumberOracle[i / Setting.COLS][i % Setting.COLS]));
        }
    }

    public void updateInfoLabel(String info) {
        infoLabel.setText("Info: " + info);
    }
}
