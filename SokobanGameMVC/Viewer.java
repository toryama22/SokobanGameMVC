import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Viewer {
    private Canvas canvas;
    private JFrame frame;


    public Viewer() {
        Controller controller = new Controller(this);
        Model model = controller.getModel();
        Levels levels = new Levels();
        canvas = new Canvas(model);
        JMenuBar menuBar = new JMenuBar();
        JMenu levelsMenu = createLevelsMenu(controller);
        JMenu optionsMenu = createOptionsMenu(controller);
        menuBar.add(levelsMenu);
        menuBar.add(optionsMenu);
        frame = new JFrame("Sokoban");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 700);
        frame.add("Center", canvas);
        frame.setJMenuBar(menuBar);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(controller);
    }

    private JMenu createOptionsMenu(Controller controller) {
        JMenuItem resetMenuItem = new JMenuItem("Reset");
        resetMenuItem.addActionListener(controller);
        resetMenuItem.setActionCommand("Reset");

        JMenu optionsMenu = new JMenu("Options");
        optionsMenu.setMnemonic('o');
        optionsMenu.add(resetMenuItem);

        return optionsMenu;
    }

    private JMenu createLevelsMenu(Controller controller) {

        JMenuItem firstLevelMenuItem = new JMenuItem("Level 1");
        firstLevelMenuItem.addActionListener(controller);
        firstLevelMenuItem.setActionCommand("Level_1");

        JMenuItem secondLevelMenuItem = new JMenuItem("Level 2");
        secondLevelMenuItem.addActionListener(controller);
        secondLevelMenuItem.setActionCommand("Level_2");

        JMenuItem thirdLevelMenuItem = new JMenuItem("Level 3");
        thirdLevelMenuItem.addActionListener(controller);
        thirdLevelMenuItem.setActionCommand("Level_3");

        JMenuItem fourthLevelMenuItem = new JMenuItem("Level 4");
        fourthLevelMenuItem.addActionListener(controller);
        fourthLevelMenuItem.setActionCommand("Level_4");

        JMenuItem fifthLevelMenuItem = new JMenuItem("Level 5");
        fifthLevelMenuItem.addActionListener(controller);
        fifthLevelMenuItem.setActionCommand("Level_5");

        JMenuItem sixthLevelMenuItem = new JMenuItem("Level 6");
        sixthLevelMenuItem.addActionListener(controller);
        sixthLevelMenuItem.setActionCommand("Level_6");

        JMenuItem seventhLevelMenuItem = new JMenuItem("Level 7");
        seventhLevelMenuItem.addActionListener(controller);
        seventhLevelMenuItem.setActionCommand("Level_7");

        JMenuItem eighthLevelMenuItem = new JMenuItem("Level 8");
        eighthLevelMenuItem.addActionListener(controller);
        eighthLevelMenuItem.setActionCommand("Level_8");

        JMenuItem ninthLevelMenuItem = new JMenuItem("Level 9");
        ninthLevelMenuItem.addActionListener(controller);
        ninthLevelMenuItem.setActionCommand("Level_9");

        JMenu levelsMenu = new JMenu("Levels");
        levelsMenu.setMnemonic('l');
        levelsMenu.add(firstLevelMenuItem);
        levelsMenu.add(secondLevelMenuItem);
        levelsMenu.add(thirdLevelMenuItem);
        levelsMenu.add(fourthLevelMenuItem);
        levelsMenu.add(fifthLevelMenuItem);
        levelsMenu.add(sixthLevelMenuItem);
        levelsMenu.add(seventhLevelMenuItem);
        levelsMenu.add(eighthLevelMenuItem);
        levelsMenu.add(ninthLevelMenuItem);


        return levelsMenu;
    }

    public void update() {
        canvas.repaint();
    }
    public boolean showDialogWon() {
        JOptionPane.showMessageDialog(frame, "You are  won!");
        return true;
    }
}
