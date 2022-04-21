public class Model {
    private Viewer viewer;
    private int[][] desktop;
    private int[][] copyOfDesktop;
    private boolean isOk;
    private int indexX;
    private int indexY;
    private Levels levels;
    
    public Model(Viewer viewer) {
        this.viewer = viewer;
        levels = new Levels();
        isOk = true;
        try {
            desktop = levels.nextLevel();
            copyOfDesktop = levels.nextLevel();
            initialization();
        } catch (Exception e) {
            isOk = false;
            System.out.println("Desktop initialization error: " + e);
        }
    }

    private void initialization() {
        for (int i = 0; i < copyOfDesktop.length; i++) {
            for (int j = 0; j < copyOfDesktop[i].length; j++) {
                if (copyOfDesktop[i][j] == 1){
                    indexX = i;
                    indexY = j;
                    break;
                }
            }
        }
    }

    public boolean isErrorState() {
        if (!isOk){
            return true;
        } else {
            return false;
        }
    }

    public void move(String direction) {
        if (direction.equals("Up")) {
            moveUp();
        } else if (direction.equals("Right")) {
            moveRight();
        } else if (direction.equals("Down")) {
            moveDown();
        } else if (direction.equals("Left")) {
            moveLeft();
        } else {
            return;
        }
        checkGoal();
        viewer.update();
        won();
    }

    private int[][] foursOnDesktop() {
        int array = 0;
        int element = 0;
        int counter = 0;
        for (int i = 0; i < copyOfDesktop.length; i++) {
            for (int j = 0; j < copyOfDesktop[i].length; j++) {
                if (copyOfDesktop[i][j] == 4) {
                    counter++;
                }
            }
        }

        int[][] indexesOfFours = new int[2][counter];

        for (int i = 0; i < copyOfDesktop.length; i++) {
            for (int j = 0; j < copyOfDesktop[i].length; j++) {
                if (copyOfDesktop[i][j] == 4) {
                    indexesOfFours[array][element] = i;
                    indexesOfFours[array + 1][element] = j;
                    element++;
                }
            }
        }

        return indexesOfFours;
    }

    private void checkGoal() {
        int[][] indexesOfFours = foursOnDesktop();
        int row = 0;
        int column = 0;
        for (int i = 0; i < indexesOfFours.length; i++) {
            for (int j = 0; j < indexesOfFours[i].length; j++) {
                row = indexesOfFours[0][j];
                column = indexesOfFours[1][j];
                if (desktop[row][column] == 0) {
                    desktop[row][column] = 4;
                }
            }
        }
    }

    private void won() {
        boolean isWon = true;
        int[][] indexesOfFours = foursOnDesktop();
        int array = 0;
        int element = 0;
        for (int i = 0; i < indexesOfFours.length; i++) {
            for (int j = 0; j < indexesOfFours[i].length; j++) {
                array = indexesOfFours[0][j];
                element = indexesOfFours[1][j];
                if (desktop[array][element] != 3) {
                    isWon = false;
                }
            }
        }

        if (isWon) {
            if (viewer.showDialogWon()) {
                try {
                    int level = levels.getLevel();
                    level = level + 1;
                    levels.setLevel(level);
                    copyOfDesktop = levels.nextLevel();
                    desktop = levels.nextLevel();
                    initialization();
                    viewer.update();
                } catch (Exception exc) {
                    isOk = false;
                    System.out.println("Error! " + exc);
                }
            }
        }
    }

    private void moveUp() {
        if (desktop[indexX - 1][indexY] == 3) {
            if (desktop[indexX - 2][indexY] == 0 || desktop[indexX - 2][indexY] == 4) {
                desktop[indexX - 1][indexY] = 0;
                desktop[indexX - 2][indexY] = 3;
            }
        }

        if (desktop[indexX - 1][indexY] == 0 || desktop[indexX - 1][indexY] == 4) {
            desktop[indexX][indexY] = 0;
            indexX = indexX - 1;
            desktop[indexX][indexY] = 1;
        } 
    }

    private void moveRight() {
        if (desktop[indexX][indexY + 1] == 3) {
            if (desktop[indexX][indexY + 2] == 0 || desktop[indexX][indexY + 2] == 4) {
                desktop[indexX][indexY + 1] = 0;
                desktop[indexX][indexY + 2] = 3;
            }
        }

        if (desktop[indexX][indexY + 1] == 0 || desktop[indexX][indexY + 1] == 4) {
            desktop[indexX][indexY] = 0;
            indexY = indexY + 1;
            desktop[indexX][indexY] = 1;
        }
    }

    private void moveDown() {
        if (desktop[indexX + 1][indexY] == 3) {
            if (desktop[indexX + 2][indexY] == 0 || desktop[indexX + 2][indexY] == 4) {
                desktop[indexX + 1][indexY] = 0;
                desktop[indexX + 2][indexY] = 3;
            }
        }

        if (desktop[indexX + 1][indexY] == 0 || desktop[indexX + 1][indexY] == 4) {
            desktop[indexX][indexY] = 0;
            indexX = indexX + 1;
            desktop[indexX][indexY] = 1;
        }
    }

    private void moveLeft() {
        if (desktop[indexX][indexY - 1] == 3) {
            if (desktop[indexX][indexY - 2] == 0 || desktop[indexX][indexY - 2] == 4) {
                desktop[indexX][indexY - 1] = 0;
                desktop[indexX][indexY - 2] = 3;
            }
        }

        if (desktop[indexX ][indexY - 1] == 0 || desktop[indexX ][indexY - 1] == 4) {
            desktop[indexX][indexY] = 0;
            indexY = indexY - 1;
            desktop[indexX][indexY] = 1;
        }
    }

    public int[][] getDesktop() {
        return desktop;
    }

    public int getLevel() {
        return levels.getLevel();
    }

    public void setDesktop(int level) throws Exception {
        levels.setLevel(level);
        desktop = levels.nextLevel();
        copyOfDesktop = levels.nextLevel();
        initialization();
        viewer.update();
    }
}
