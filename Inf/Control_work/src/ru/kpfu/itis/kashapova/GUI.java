package ru.kpfu.itis.kashapova;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class GUI extends JFrame{
    private static String URLphoto = "https://img5tv.cdnvideo.ru/webp/shared/files/201903/1_900942.jpg";
    public static void createGUI()
    {
        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelmain = new JPanel();
        frame.add(panelmain);
        createMenuBar(frame);
        createButtonBar(frame, panelmain);
    }

    public static void createMenuBar(JFrame frame){
        Font font = new Font("Verdana", Font.PLAIN, 16);

        JMenuBar menuBar = new JMenuBar();

        // 'кнопка' file
        JMenu fileMenu = new JMenu("File");
        fileMenu.setFont(font);

        // кнопка about
        JMenuItem about = new JMenuItem("About");
        about.setFont(font);
        fileMenu.add(about);
        // добавлене слушателя для создания модально окна
        about.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // Создание экземпляра JDialog в соответствии с внешней формой
                JDialog d = new JDialog(frame);
                d.setModal(true);

                d.setTitle("This modal window");
                d.setSize(300, 300);

                d.setLocationRelativeTo(frame);
                d.setVisible(true);
            }
        });

        // выход
        fileMenu.addSeparator();

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setFont(font);
        fileMenu.add(exitItem);

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);

        frame.setPreferredSize(new Dimension(500, 500));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void createButtonBar(JFrame frame, JPanel panelmain){

        JPanel mypanel = new JPanel();

        frame.getContentPane().add(mypanel, BorderLayout.LINE_END);
        mypanel.setPreferredSize(new Dimension(200,100));
        // к панели добавляем менеджер GridLayout и устанавливаем размеры таблицы 3*3.
        mypanel.setLayout(new GridLayout(6,1));
        // к панели добавляем кнопку и устанавливаем для нее менеджер в верхнее расположение.
        JButton button1 = new JButton("red");
        mypanel.add(button1);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelmain.setBackground(Color.red);
            }
        });

        JButton button2 = new JButton("NK");
        mypanel.add(button2);
        JLabel label = new JLabel();
        label.setBackground(Color.WHITE);
        label.setOpaque(true);
        frame.getContentPane().add(label, BorderLayout.CENTER);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Image img = null;
                try {
                    img = loadImage();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                label.setIcon(new ImageIcon(img, "NK"));
            }
        });
        frame.add(label);
        mypanel.add(new JButton("rotate"));
    }

    private static Image loadImage() throws IOException {
        try {
            String fileName = "NK";
            BufferedImage img = ImageIO.read(new URL(GUI.URLphoto));
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            ImageIO.write(img, "png", file);
            return img;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
