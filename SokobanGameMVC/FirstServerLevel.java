import java.io.Serializable;

public class FirstServerLevel extends Desktop {
    private int[][] desktop;

    public FirstServerLevel() {
        desktop = new int[][] {
                {0, 0, 2, 2, 2, 2, 2, 2},
                {0, 0, 2, 0, 0, 0, 0, 2},
                {2, 2, 2, 3, 3, 3, 0, 2},
                {2, 1, 0, 3, 4, 4, 0, 2},
                {2, 0, 3, 4, 4, 4, 2, 2},
                {2, 2, 2, 2, 0, 0, 2, 0},
                {0, 0, 0, 2, 2, 2, 2, 0}
        };
    }

    public int[][] getDesktop() {
        return desktop;
    }
}
