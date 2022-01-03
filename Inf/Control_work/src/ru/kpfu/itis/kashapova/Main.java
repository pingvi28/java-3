package ru.kpfu.itis.kashapova;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GUI myGUI = new GUI();

        JFrame.setDefaultLookAndFeelDecorated(true);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                myGUI.createGUI();
            }
        });
    }
}
