import java.io.Serializable;

public class LastServerLevel extends Desktop {
    private int[][] desktop;

    public LastServerLevel() {
        desktop = new int[][] {
                {0, 0, 2, 2, 2, 2, 2, 2, 2, 2},
                {0, 0, 2, 0, 0, 0, 0, 2, 2, 2},
                {0, 0, 2, 0, 3, 0, 0, 0, 0, 2},
                {2, 2, 2, 0, 3, 0, 2, 2, 0, 2},
                {2, 4, 4, 4, 0, 3, 0, 0, 0, 2},
                {2, 4, 4, 4, 3, 2, 3, 0, 2, 2},
                {2, 2, 2, 2, 0, 2, 0, 3, 0, 2},
                {0, 0, 0, 2, 0, 0, 0, 1, 0, 2},
                {0, 0, 0, 2, 2, 2, 2, 2, 2, 2}
        };
    }

    public int[][] getDesktop() {
        return desktop;
    }
}
