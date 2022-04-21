import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


public class Controller implements KeyListener, ActionListener {
    private Model model;

    public Controller(Viewer viewer) {
        model = new Model(viewer);
    }

    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case 37:
                model.move("Left");
                break;
            case 38:
                model.move("Up");
                break;
            case 39:
                model.move("Right");
                break;
            case 40:
                model.move("Down");
                break;

            default:
                return;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public Model getModel() {
        return model;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        switch (command) {
            case "Level_1":
                try {
                    model.setDesktop(1);
                } catch (Exception exc) {
                    System.out.println("Initialization error: " + exc);
                }
                break;
            case "Level_2":
                try {
                    model.setDesktop(2);
                } catch (Exception exc) {
                    System.out.println("Initialization error: " + exc);
                }
                break;
            case "Level_3":
                try {
                    model.setDesktop(3);
                } catch (Exception exc) {
                    System.out.println("Initialization error: " + exc);
                }
                break;
            case "Level_4":
                try {
                    model.setDesktop(4);
                } catch (Exception exc) {
                    System.out.println("Initialization error: " + exc);
                }
                break;
            case "Level_5":
                try {
                    model.setDesktop(5);
                } catch (Exception exc) {
                    System.out.println("Initialization error: " + exc);
                }
                break;
            case "Level_6":
                try {
                    model.setDesktop(6);
                } catch (Exception exc) {
                    System.out.println("Initialization error: " + exc);
                }
                break;

            case "Level_7":
                try {
                    model.setDesktop(7);
                } catch (Exception exc) {
                    System.out.println("Initialization error: " + exc);
                }
                break;
            case "Level_8":
                try {
                    model.setDesktop(8);
                } catch (Exception exc) {
                    System.out.println("Initialization error: " + exc);
                }
                break;
            case "Level_9":
                try {
                    model.setDesktop(9);
                } catch (Exception exc) {
                    System.out.println("Initialization error: " + exc);
                }
                break;
            case "Reset":
                try {
                    int level = model.getLevel();
                    model.setDesktop(level);
                } catch (Exception exc) {
                    System.out.println("Initialization error: " + exc);
                }
                break;
            default:
                try {
                    model.setDesktop(1);
                } catch (Exception exc) {
                    System.out.println("Initialization error");
                }
                break;
        }
    }

}
