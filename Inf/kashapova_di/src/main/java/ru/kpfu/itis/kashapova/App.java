package ru.kpfu.itis.kashapova;

import ru.kpfu.itis.kashapova.gui.GUI;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        final GUI myGUI = new GUI();

        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                myGUI.createGUI();
            }
        });
    }
}
