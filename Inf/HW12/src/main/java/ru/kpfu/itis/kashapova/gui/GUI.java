package ru.kpfu.itis.kashapova.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUI extends JFrame{
    private int width;
    private int height;
    private final String Path = "src/main/resources/";
    private final String[] hair = {"hair/1.png","hair/2.png","hair/3.png","hair/4.png","hair/5.png"};
    private final String[] eye = {"eyes/1.png","eyes/2.png","eyes/3.png","eyes/4.png","eyes/5.png"};
    private final String[] nose = {"nose/1.png","nose/2.png","nose/3.png","nose/4.png","nose/5.png"};
    private final String[] lips = {"lips/1.png","lips/2.png","lips/3.png","lips/4.png","lips/5.png"};

    private final Font font = new Font("Verdana", Font.PLAIN, 22);
    private JFrame mainFrame = new JFrame();
    private final JLabel faceLabel = new JLabel();
    private final JLabel eyeLabel = new JLabel();
    private final JLabel noseLabel = new JLabel();
    private final JLabel lipsLabel = new JLabel();
    private final JPanel nav = new JPanel();
    private final JPanel navbutton = new JPanel();

    public GUI() {
        this.createWindow();
    }

    public void createGUI() {
        this.mainFrame.setVisible(true);
    }

    private void createWindow() {
        this.mainFrame = createMainFrame();
        this.addElement(this.mainFrame.getContentPane());
    }

    protected JFrame createMainFrame(){
        this.mainFrame = new JFrame("Photorobot");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getWidthHeight();
        this.mainFrame.setPreferredSize(new Dimension(this.width - this.width/3, this.height));
        this.mainFrame.pack();
        this.mainFrame.setLocationRelativeTo(null);
        return this.mainFrame;
    }

    protected void addElement(Container container){
        container.setLayout(new BorderLayout());
        container.add(createNavigationPanel(), BorderLayout.EAST);
        this.mainFrame.pack();

        container.add(createFaceLabel(this.noseLabel));
        noseLabel.setBounds(width/5 + 20,height/2 - 10,200,200);
        mainFrame.add(noseLabel);

        container.add(createFaceLabel(this.lipsLabel));
        lipsLabel.setBounds(width/5 ,2 * height/3 - 20,250,200);
        mainFrame.add(lipsLabel);

        container.add(createFaceLabel(this.eyeLabel));
        eyeLabel.setLocation( - 20, - height / 22);
        mainFrame.add(eyeLabel);
        this.mainFrame.pack();

        container.add(createFaceLabel(this.faceLabel));
        this.mainFrame.pack();

        container.add(new JPanel());
    }

    protected JLabel createFaceLabel(JLabel label){
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    protected JPanel createNavigationPanel(){
        this.nav.setLayout(new FlowLayout());
        this.nav.setBackground(Color.white);
        this.nav.add(createNavigationButtonPanel());
        return this.nav;
    }

    protected JPanel createNavigationButtonPanel(){
        navbutton.setLayout(new GridLayout(10, 2, 10,15));
        navbutton.setBackground(Color.white);

        forButton(hair, "hair", this.faceLabel, this.navbutton,width/2 - 20,this.height - 10 );
        forButton(eye, "eyes", this.eyeLabel, this.navbutton,550,170);
        forButton(nose, "nose", this.noseLabel, this.navbutton,150,200 );
        forButton(lips, "lips", this.lipsLabel, this.navbutton,250,150 );
        return this.navbutton;
    }

    private void forButton(String[] arg, String text, JLabel label, JPanel panel,int widthIn,int height){
        for (int i = 0; i < arg.length; i++){
            createButtonWithOutImage(text + " " + (i+1),Path + arg[i], label, panel, widthIn, height);
        }
    }

    private void getWidthHeight(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.width = dimension.width;
        this.height = dimension.height;
    }

    private void createButtonWithOutImage(String i, final String filename, final JLabel label, JPanel panel, final int widthIn, final int height){
        JButton button = new JButton(i);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setIcon(new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(widthIn, height, Image.SCALE_SMOOTH)));
            }
        });
        button.setFont(this.font);
        panel.add(button);
    }
}
