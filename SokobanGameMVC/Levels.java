import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class Levels {
    public static final String HOST_NAME = "194.152.37.7";
    public static final int PORT_NUMBER = 4446;
    private int level;
    public Levels() {
        level = 1;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
    public int[][] nextLevel() throws Exception {
        int[][] desktop = null;
        switch (level) {
            case 1:
                desktop = getFirstLevel();
                break;
            case 2:
                desktop = getSecondLevel();
                break;
            case 3:
                desktop = getThirdLevel();
                break;
            case 4:
                desktop = getFourthLevel();
                break;
            case 5:
                desktop = getFifthLevel();
                break;
            case 6:
                desktop = getSixthLevel();
                break;
            case 7:
                desktop = getServerLevel("Level_7");
                break;
            case 8:
                desktop = getServerLevel("Level_8");
                break;
            case 9:
                desktop = getServerLevel("Level_9");
                break;
            default:
                level = 1;
                desktop = getFirstLevel();
                break;
        }
        return desktop;
    }

    public int[][] getFourthLevel() {
        File file = new File("levels/level4.txt");
        try {
            String contentFile = getContentFile(file);
            int desktop[][] = convertStringIntoTwoDimesionArray(contentFile);
            return desktop;
        } catch (Exception exc) {
            System.out.println("Getting content error: " + exc);
        }
        return null;
    }
    public int[][] getFifthLevel() {
        File file = new File("levels/level5.txt");
        try {
            String contentFile = getContentFile(file);
            int desktop[][] = convertStringIntoTwoDimesionArray(contentFile);
            return desktop;
        } catch (Exception exc) {
            System.out.println("Getting content error: " + exc);
        }
        return null;
    }
    public int[][] getSixthLevel() {
        File file = new File("levels/level6.txt");
        try {
            String contentFile = getContentFile(file);
            int desktop[][] = convertStringIntoTwoDimesionArray(contentFile);
            return desktop;
        } catch (Exception exc) {
            System.out.println("Getting content error: " + exc);
        }
        return null;

    }

    public int[][] getFirstLevel() {
        int[][] desktop = new int[][] {
                {0, 0, 2, 2, 2, 2, 2, 0, 0, 0},
                {2, 2, 2, 0, 0, 0, 2, 0, 0, 0},
                {2, 4, 1, 3, 0, 0, 2, 0, 0, 0},
                {2, 2, 2, 0, 3, 4, 2, 0, 0, 0},
                {2, 4, 2, 2, 3, 0, 2, 0, 0, 0},
                {2, 0, 2, 0, 4, 0, 2, 2, 0, 0},
                {2, 3, 0, 3, 3, 3, 4, 2, 0, 0},
                {2, 0, 0, 0, 4, 0, 0, 2, 0, 0},
                {2, 2, 2, 2, 2, 2, 2, 2, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        return desktop;
    }


    public int[][] getSecondLevel() {
        int[][] desktop = new int[][] {
                {2, 2, 2, 2, 2, 2, 2, 0, 0, 0,},
                {2, 4, 4, 3, 4, 4, 2, 0, 0, 0,},
                {2, 4, 4, 2, 4, 4, 2, 0, 0, 0,},
                {2, 0, 3, 3, 3, 0, 2, 0, 0, 0,},
                {2, 0, 0, 3, 0, 0, 2, 0, 0, 0,},
                {2, 0, 3, 3, 3, 0, 2, 0, 0, 0,},
                {2, 0, 0, 2, 1, 0, 2, 0, 0, 0,},
                {2, 2, 2, 2, 2, 2, 2, 0, 0, 0,},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,}
        };

        return desktop;
    }

    public int[][] getThirdLevel() {
        int[][] desktop = new int[][] {
                {0, 2, 2, 2, 2, 2, 2, 2, 0, 0},
                {0, 2, 0, 0, 0, 0, 0, 2, 2, 2},
                {2, 2, 3, 2, 2, 2, 0, 0, 0, 2},
                {2, 0, 1, 0, 3, 0, 0, 3, 0, 2},
                {2, 0, 4, 4, 2, 0, 3, 0, 2, 2},
                {2, 2, 4, 4, 2, 0, 0, 0, 2, 0},
                {0, 2, 2, 2, 2, 2, 2, 2, 2, 0}
        };
        return desktop;
    }

    public int[][] getServerLevel(String level) {
        try (
                Socket socket = new Socket(HOST_NAME, PORT_NUMBER);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {
            out.println(level);
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Desktop desktopOfServer = (Desktop) in.readObject();
            int[][] desktop = desktopOfServer.getDesktop();
            in.close();
            return desktop;


        } catch(IOException | ClassNotFoundException ioe) {
            System.out.println("Error: " + ioe);
            this.level = 1;
            return getFirstLevel();

        }
    }
    
    

    private int[][] convertStringIntoTwoDimesionArray(String line) {
        int n = line.length();
        int row = 0;
        for (int i = 0; i < n; i++) {
            char symbol = line.charAt(i);
            if (symbol == '\n') {
                row = row + 1;
            }
        }
        int[][] array = new int[row][];

        int column = 0;
        int a = 0;

        for (int i = 0; i < n; i++) {
            char symbol = line.charAt(i);
            if (symbol != '\n') {
                column = column + 1;
            }
            if (symbol == '\n') {
                array[a] = new int[column];
                a = a + 1;
                column = 0;
            }

        }

        row = 0;
        column = 0;

        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            if (symbol != '\n') {
                array[row][column] = Integer.parseInt("" + symbol);
                column = column + 1;
            } else if (symbol == '\n') {
                row = row + 1;
                column = 0;
            }
        }
        return array;
    }

    private String getContentFile(File file) throws Exception {
        try(FileInputStream in = new FileInputStream(file)) {
            int size = (int) file.length();
            char[] array = new char[size];
            int unicode;
            int index = 0;
            while ((unicode = in.read()) != -1) {
                char symbol = (char) unicode;
                if (('0' <= symbol && symbol <= '4') || (symbol == '\n')) {
                    array[index] = symbol;
                    index = index + 1;
                }
            }

            array[index++] = '\n';
            String content = new String(array, 0, index);
            return content;

        } catch (FileNotFoundException fnfe) {
            throw new Exception("File Not Found Exception: " + fnfe);
        } catch (IOException ioe) {
            throw new Exception("Basic I/O Exception: " + ioe);
        }

    }

}
