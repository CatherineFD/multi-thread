package listeners;
import controller.Controller;
import view.View;
import setting.WindowCreator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class ButtonListener implements ActionListener {
        private final Controller controller;

        public ButtonListener(Controller controller) {
            this.controller = controller;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            int selectedNumber = Integer.parseInt(source.getText());

            controller.checkNumber(selectedNumber);
            controller.getAllNumber();
        }
    }

