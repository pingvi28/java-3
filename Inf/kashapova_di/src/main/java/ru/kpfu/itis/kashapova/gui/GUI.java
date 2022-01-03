package ru.kpfu.itis.kashapova.gui;

import ru.kpfu.itis.kashapova.exceptions.LookAndFeelException;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class GUI {
    private int widthScreen;
    private int heightScreen;
    private int widthTG = 50;
    private int heightTG = 50;
    private static final String MENU_TEXT = "File";
    private static final String ABOUT_TEXT = "About";
    private static final String EXIT_TEXT = "Exit";
    private static final String MODAL_FRAME_TITLE = "Modal frame";
    private final Float PRIMARY_FONT_SIZE = 18F;
    private final String APP_NAME = "Simple GUI";
    private final String DEFAULT_STATUS = "The app is running";
    private static final Color TG_COLOR = new Color(0, 136, 204);
    private Font font = new Font("Verdana", Font.PLAIN, 16);
    private JLabel appStatus;
    private JPanel view;
    private JPanel statusPanel;
    private JFrame mainFrame;
    private JLabel chats;
    private String filenameChat = "src/main/resources/chat.png";
    private Dimension labelSize = new Dimension(400, 70);
    private Border solidBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
    private int countChat = 20;

    public GUI() {
        appStatus = new JLabel(DEFAULT_STATUS);
        createWindow();
    }

    public void createGUI() {
        mainFrame.setVisible(true);
    }

    private void createWindow() {
        this.mainFrame = new JFrame(APP_NAME);
        this.mainFrame.setResizable(true);
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getWidthHeight();
        this.mainFrame.setPreferredSize(new Dimension(this.widthScreen - this.widthScreen /3, this.heightScreen - this.heightScreen /3));
        this.mainFrame.setMinimumSize(new Dimension(this.widthScreen /2, this.heightScreen /2));
        this.mainFrame.pack();
        this.mainFrame.setLocationRelativeTo(null);
        setLookAndFeel();
        addPanels(mainFrame.getContentPane());
    }

    private void getWidthHeight(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.widthScreen = dimension.width;
        this.heightScreen = dimension.height;
    }

    private void addPanels(Container container) {
        container.setLayout(new BorderLayout());
        container.add(createMenuBar(), BorderLayout.NORTH);
        container.add(createChatsPanel(), BorderLayout.WEST);
        container.add(createOpenChatPanel(), BorderLayout.CENTER);
    }

    private Component createStatusPanel() {
        statusPanel = new JPanel();
        Component button = null;
        try{
            //Icon icon = new ImageIcon("src/main/resources/down.png");

            button = new JButton(new ImageIcon(new ImageIcon("src/main/resources/down.png").getImage().getScaledInstance(17, 22, Image.SCALE_SMOOTH)));
        }catch (Exception ex){
            System.out.println("GUI createStatusPanel()# cant find send icon");
        }

        Component field = new JTextField(30);


        statusPanel.add(field);
        try {
            statusPanel.add(button);
        }catch (NullPointerException ex){
            System.out.println("GUI createStatusPanel()# cant add send icon");
        }

        return statusPanel;
    }

    private Component createMenuBar() {
        JPanel mPanel = new JPanel();
        mPanel.setLayout(new FlowLayout());
        mPanel.add(createMenu(),BorderLayout.WEST);
        return mPanel;
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();
        // 'кнопка' file
        JMenu menu = new JMenu(BorderLayout.WEST);
        menu.setText(MENU_TEXT);
        menu.setFont(font);
        menu.setBackground(TG_COLOR);
        menu.add(createModalWindowItem());
        menu.add(createExitItem());
        menuBar.add(menu);
        return menuBar;
    }

    private JMenuItem createModalWindowItem() {
        JMenuItem modalWindowItem = new JMenuItem();
        modalWindowItem.setText(ABOUT_TEXT);
        modalWindowItem.addActionListener(e -> {
            JDialog frame = new JDialog(mainFrame, MODAL_FRAME_TITLE, true);
            frame.setLayout(new BorderLayout());
            frame.setBounds(100,100, 200, 150);
            frame.getContentPane().add(createTextField("THIS NEW LAYOUT!", PRIMARY_FONT_SIZE), BorderLayout.CENTER);
            frame.setVisible(true);
        });
        return modalWindowItem;
    }

    private JMenuItem createExitItem() {
        JMenuItem exitItem = new JMenuItem();
        exitItem.setText(EXIT_TEXT);
        exitItem.addActionListener(e -> {
            mainFrame.dispose();
        });
        return exitItem;
    }

    private JLabel createTextField(String text, Float fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(label.getFont().deriveFont(fontSize));
        return label;
    }

    private Component createOpenChatPanel() {
        view = new JPanel();
        System.out.println(chats.getWidth() + " " + chats.getHeight());
        view.setSize(new Dimension(mainFrame.getWidth() - chats.getWidth(), mainFrame.getHeight() - chats.getHeight()));
        setViewPanelColor(Color.WHITE);
        view.add(createStatusPanel(),BorderLayout.SOUTH);
        return view;
    }

    private JScrollPane createChatsPanel() {
        JPanel chats = new JPanel();
        chats.setLayout(new BoxLayout(chats, BoxLayout.PAGE_AXIS));
        setContent(chats);
        JScrollPane pane = new JScrollPane(chats, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        pane.setPreferredSize(labelSize);
        return pane;
    }

    private void setContent(JPanel chat) {
        chat.setLayout(new BoxLayout(chat, BoxLayout.PAGE_AXIS));
        for (int i = 0; i < countChat; i++) {
            chat.add(createImageButton());
        }
    }

    private Component createImageButton() {
        chats = new JLabel("какой -то чат");
        chats.setFont(font);
        chats.setIcon(new ImageIcon(new ImageIcon(filenameChat).getImage().getScaledInstance(widthTG, heightTG, Image.SCALE_SMOOTH)));
        chats.setVerticalTextPosition(JLabel.TOP);
        chats.setHorizontalTextPosition(JLabel.RIGHT);
        chats.setPreferredSize(labelSize);
        chats.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 10));
        return createChatPanel(chats);
    }

    private JPanel createChatPanel(JLabel label){
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 100));
        panel.add(label);
        panel.setFont(new Font("Verdana", Font.PLAIN, 14));
        return panel;
    }

    private void setViewPanelColor(Color color) {
        view.setBackground(color);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException e) {
            System.out.println("GUI#setLookAndFeel : Can't set look and fee");
        } catch (IllegalAccessException e) {
            System.out.println("GUI#setLookAndFeel : Illegal access");
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println("GUI#setLookAndFeel : ");
            throw new LookAndFeelException("Unsupported Look And Feel", e);
        }
    }
}
